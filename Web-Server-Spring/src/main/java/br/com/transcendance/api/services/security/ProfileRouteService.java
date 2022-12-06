package br.com.transcendance.api.services.security;

import java.util.Collection;

import br.com.transcendance.api.models.security.ProfileRoute;
import br.com.transcendance.api.services.AbstractBaseService;

public interface ProfileRouteService extends AbstractBaseService<ProfileRoute, Long> {

	Collection<ProfileRoute> findByRouteId(Long routeId);

}
