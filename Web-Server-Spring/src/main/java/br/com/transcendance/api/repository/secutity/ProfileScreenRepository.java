package br.com.transcendance.api.repository.secutity;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.security.ProfileScreen;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface ProfileScreenRepository extends AbstractBaseRepository<ProfileScreen, Long> {
	// Busca os perfis autorizados em cada screen
	Collection<ProfileScreen> findByScreenId(Long screenId);

	Collection<ProfileScreen> findByProfileId(Long profileId);

	ProfileScreen findByProfileIdAndScreenId(Long profileId, Long screenId);
}
