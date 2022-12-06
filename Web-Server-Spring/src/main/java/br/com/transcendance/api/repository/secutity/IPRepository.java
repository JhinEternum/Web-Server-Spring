package br.com.transcendance.api.repository.secutity;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.security.IP;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface IPRepository extends AbstractBaseRepository<IP, Long> {

}
