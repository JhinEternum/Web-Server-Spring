package br.com.transcendance.api.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.transcendance.api.models.security.ProfileRoute;
import br.com.transcendance.api.models.security.Route;
import br.com.transcendance.api.repository.secutity.UserRepository;
import br.com.transcendance.api.services.security.IPService;
import br.com.transcendance.api.services.security.ProfileRouteService;
import br.com.transcendance.api.services.security.RouteService;
import br.com.transcendance.api.services.security.UserService;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserRepository repository;

	@Autowired
	private UserService usuarioService;

	@Autowired
	private IPService ipService;

	@Autowired
	private RouteService routeService;

	@Autowired
	private ProfileRouteService profileRouteService;

	@Autowired
	@Qualifier("handlerExceptionResolver")
	private HandlerExceptionResolver resolver;

	@Autowired
	private Environment env;

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	// Configurations for authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
	}

	// Configuration for authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		if (Arrays.asList(env.getActiveProfiles()).contains("dev")) {
			http.headers().frameOptions().disable();
		}

		// http.cors().and().csrf().disable();
		// http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		// http.authorizeRequests().anyRequest().permitAll();

		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/auth").permitAll().antMatchers(HttpMethod.POST, "/usuario/logout")
				.permitAll();

		http.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/service/category").permitAll()
				.antMatchers(HttpMethod.GET, "/service/category/all").permitAll();

		// buscar lista de endpoints no banco
		List<Route> routes = routeService.findAll();

		// Para cada endpoint ...
		for (Route rota : routes) {

			// buscar os profiles autorizados em cada endpoint
			Collection<ProfileRoute> profiles = profileRouteService.findByRouteId(rota.getId());

			List<String> nameProfiles = new ArrayList<>();
			for (ProfileRoute profile : profiles) {
				nameProfiles.add(profile.getProfile().getName());
			}
			String[] arrayPerfis = nameProfiles.toArray(new String[0]);

			for (String p : arrayPerfis) {
				System.out.println(rota.getName() + " " + p);
			}

			// Para cada rota é adicionada a lista de profiles autorizados a acessar a mesma
			http.authorizeRequests().antMatchers(rota.getName()).hasAnyAuthority(arrayPerfis);
		}

		http.authorizeRequests()
				.anyRequest().authenticated()
				// .anyRequest().permitAll()
				.and().cors()
				.and().csrf().disable()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
				.and().addFilterBefore(
						new TokenAuthenticationFilter(tokenService, repository, resolver, usuarioService, ipService),
						UsernamePasswordAuthenticationFilter.class);

		// System.out.println(http.getObject().toString());

	}

	@Bean
	@SuppressWarnings("deprecation")
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}

}