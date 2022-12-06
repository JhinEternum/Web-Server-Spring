package br.com.transcendance.api.repository.secutity;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface UserRepository extends AbstractBaseRepository<User, Long> {

	User findByUserName(String userName);

	User findById(long id);

}
