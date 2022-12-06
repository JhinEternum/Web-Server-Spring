package br.com.transcendance.api.services.security;

import br.com.transcendance.api.models.security.Screen;
import br.com.transcendance.api.services.AbstractBaseService;

public interface ScreenService extends AbstractBaseService<Screen, Long> {

	Screen findByName(String name);

}
