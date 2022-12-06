package br.com.transcendance.api.log;

import java.util.Base64;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.services.security.UserService;

@Component
public class LogUtil {

	private static UserService userService;

	@Autowired
	public LogUtil(UserService userService) {
		LogUtil.userService = userService;
	}

	public static String formatMessageInfo(String mensagem) {
		return "TRACKID: " + getTrackID() + " " + mensagem;
	}

	public static String formatMessageError(String mensagem, String error) {
		return "TRACKID: " + getTrackID() + " " + mensagem + " CAUSA: " + error;
	}

	public static String getTrackID() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();

		User user = userService.currentUserDetails();
		String id;
		String name;
		if (user == null) {
			id = attr.getRequest().getSession().getId();
			name = "anonimo";
		} else {
			id = user.getId() + "";
			name = user.getUsername();
		}
		// Usuario user = currentUserDetails();

		String trackID = id + "-" + name + attr.getRequest().getSession().getId();

		return Base64.getEncoder().encodeToString(trackID.getBytes());
	}

	public static String generateCodeError() {

		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String sessionID = attr.getRequest().getSession().getId();

		int randomWithThreadLocalRandom = ThreadLocalRandom.current().nextInt();

		String codeError = sessionID + "-" + randomWithThreadLocalRandom;

		return codeError;
	}

	public static User currentUserDetails() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		if (authentication != null) {
			return (User) authentication.getPrincipal();
		}
		return null;
	}

}
