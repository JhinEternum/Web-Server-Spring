package br.com.transcendance.api.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.exception.RegrasNegocioException;
import br.com.transcendance.api.log.LogUtil;
import br.com.transcendance.api.models.Result;
import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.security.TokenService;
import br.com.transcendance.api.services.security.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController extends AbstractController<User, Long> {

	private UserService service;

	@Autowired
	private TokenService tokenService;

	@Autowired
	public UserController(UserService service) {
		super(service);
	}

	@GetMapping("/me")
	public ResponseEntity<Result> me(HttpServletRequest request) {

		Result result = new Result();

		log.info(LogUtil.formatMessageInfo("Buscando informações do usuário"));

		User user = service.currentUserDetails();

		log.info(LogUtil.formatMessageInfo("Busca de informações do usuário realizada com sucesso"));

		result.setObject(user);
		result.setSuccess(true);
		result.setMessage("Busca de informações do usuário realizada com sucesso");

		return ResponseEntity.ok(result);

	}

	@RequestMapping(value = "/logout")
	public ResponseEntity<Result> logout(
			@RequestHeader(value = "Authorization", required = false) String authorization) {

		Result result = new Result();

		try {
			log.info(LogUtil.formatMessageInfo(getMessageUtil().getInfoLogout()));

			tokenService.addTokenToBlackList(authorization,
					tokenService.getTokenId(tokenService.substringToken(authorization)));

			log.info(LogUtil.formatMessageInfo(getMessageUtil().getInfoLogoutSucesso()));

			result.setMessage(getMessageUtil().getInfoLogoutSucesso());
			result.setObject(null);
			result.setSuccess(true);

			return ResponseEntity.ok(result);

		} catch (Exception e) {
			throw new RegrasNegocioException(getMessageUtil().getErrorLogout());
		}
	}

}
