package br.com.transcendance.api.services.security;

import org.springframework.stereotype.Component;

import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.services.AbstractBaseService;

@Component("userService")
public interface UserService extends AbstractBaseService<User, Long> {

	User me();

	User findByUserName(String userName);

	User currentUserDetails();

	boolean userAtivo(User user);

	boolean autorizado(User user, String ip);
	// Collection<ProdutorMaquina> findByProdutorMaquinaId(Long produtorId);

}
