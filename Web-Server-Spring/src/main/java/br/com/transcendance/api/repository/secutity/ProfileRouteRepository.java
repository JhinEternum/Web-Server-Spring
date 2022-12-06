package br.com.transcendance.api.repository.secutity;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.security.ProfileRoute;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface ProfileRouteRepository extends AbstractBaseRepository<ProfileRoute, Long> {
	// buscar os perfis autorizados em cada rota
	Collection<ProfileRoute> findByRouteId(Long rotaId);
}
