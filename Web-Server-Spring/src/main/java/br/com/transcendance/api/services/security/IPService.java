package br.com.transcendance.api.services.security;

import javax.servlet.http.HttpServletRequest;

import br.com.transcendance.api.models.security.IP;
import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.services.AbstractBaseService;

public interface IPService extends AbstractBaseService<IP, Long> {

	String getIPFromHeader(HttpServletRequest request);

	boolean ipAutorizado(String ipFront, User usuario);
}
