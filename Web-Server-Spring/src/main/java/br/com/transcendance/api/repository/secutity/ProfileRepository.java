package br.com.transcendance.api.repository.secutity;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.security.Profile;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface ProfileRepository extends AbstractBaseRepository<Profile, Long> {

}
