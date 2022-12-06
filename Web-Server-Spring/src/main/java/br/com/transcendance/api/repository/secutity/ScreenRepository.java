package br.com.transcendance.api.repository.secutity;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.security.Screen;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface ScreenRepository extends AbstractBaseRepository<Screen, Long> {

	Screen findByName(String name);

}
