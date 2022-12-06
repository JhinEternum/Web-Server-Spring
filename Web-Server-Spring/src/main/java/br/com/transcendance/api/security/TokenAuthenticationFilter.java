package br.com.transcendance.api.security;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import br.com.transcendance.api.exception.TokenBlacListException;
import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.repository.secutity.UserRepository;
import br.com.transcendance.api.services.security.IPService;
import br.com.transcendance.api.services.security.UserService;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final UserRepository repository;
	private final UserService usuarioService;
	private final HandlerExceptionResolver resolver;
	private final IPService ipService;

	public TokenAuthenticationFilter(TokenService tokenService, UserRepository repository,
			HandlerExceptionResolver resolver, UserService usuarioService, IPService ipService) {
		this.tokenService = tokenService;
		this.repository = repository;
		this.resolver = resolver;
		this.usuarioService = usuarioService;
		this.ipService = ipService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

		try {
			String tokenFromHeader = tokenService.getTokenFromHeader(request);
			String ip = ipService.getIPFromHeader(request);
			boolean tokenValid = tokenService.isTokenValid(tokenFromHeader);
			if (tokenValid) {
				this.autorizado(tokenFromHeader, ip);
			}

			filterChain.doFilter(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resolver.resolveException(request, response, null, e);
		}
	}

	private void autorizado(String tokenFromHeader, String ip) {

		Integer id = tokenService.getTokenId(tokenFromHeader);

		User user = usuarioService.findById(Long.valueOf(id));

		if (!tokenService.tokenInBlackList(tokenFromHeader)) {

			if (usuarioService.autorizado(user, ip)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						user, null, user.getProfiles());
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		} else {
			throw new TokenBlacListException();
		}
	}

}
