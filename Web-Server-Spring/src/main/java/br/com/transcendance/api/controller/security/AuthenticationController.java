package br.com.transcendance.api.controller.security;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.dto.LoginDTO;
import br.com.transcendance.api.dto.TokenDTO;
import br.com.transcendance.api.log.LogUtil;
import br.com.transcendance.api.models.Result;
import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.security.TokenService;
import br.com.transcendance.api.services.security.UserService;
import br.com.transcendance.api.util.MessageUtil;
import lombok.extern.slf4j.Slf4j;

@PropertySource("classpath:messages.properties")
@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private UserService userService;

	@Autowired
	private MessageUtil messageUtil;

	@PostMapping
	public ResponseEntity<Result> auth(@RequestBody @Validated LoginDTO loginDTO, HttpServletRequest request) {

		Result result = new Result();

		log.info(LogUtil.formatMessageInfo(messageUtil.getInfoLogin()));
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				loginDTO.getUser(), loginDTO.getPass());

		Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

		String token = tokenService.generateToken(authentication);

		userService.autorizado((User) authentication.getPrincipal(), request.getRemoteAddr());

		log.info(LogUtil.formatMessageInfo("token: " + token));

		result.setObject(TokenDTO.builder().type("Bearer").token(token).build());
		result.setSuccess(true);
		result.setMessage(messageUtil.getInfoLoginSucesso());

		return ResponseEntity.ok(result);

	}
}
