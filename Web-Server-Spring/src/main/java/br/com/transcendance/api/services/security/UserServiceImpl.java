package br.com.transcendance.api.services.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.exception.IPNaoAutorizadoException;
import br.com.transcendance.api.models.security.User;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.secutity.UserRepository;
import br.com.transcendance.api.security.TokenService;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class UserServiceImpl extends AbstractBaseRepositoryImpl<User, Long>
		implements UserService {

	private UserRepository myDomainRepository;

	@Autowired
	private TokenService tokenService;

	@Autowired
	private IPService ipService;

	// @Autowired
	// private PessoaService pessoaService;

	public UserServiceImpl(UserRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	@Override
	public User me() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		User user = (User) authentication.getPrincipal();
		return myDomainRepository.findById(user.getId());
	}

	@Override
	public User findByUserName(String userName) {
		return myDomainRepository.findByUserName(userName);
	}

	public User currentUserDetails() {
		SecurityContext securityContext = SecurityContextHolder.getContext();
		Authentication authentication = securityContext.getAuthentication();
		System.out.println();
		if (authentication != null && (authentication.getPrincipal() instanceof User)) {
			System.out.println(authentication.getPrincipal());
			return (User) authentication.getPrincipal();
		}
		return null;
	}

	public boolean userAtivo(User user) {
		if (user != null) {
			if (user.isActive() == true) {
				return true;
			}
		}
		return false;
	}

	public boolean autorizado(User user, String ip) {

		if (user != null) {

			if (userAtivo(user)) {

				if (user.isValidateIp()) {
					if (ipService.ipAutorizado(ip, user)) {
						return true;
					} else {
						throw new IPNaoAutorizadoException();
					}
				} else {
					return true;
				}

			} else {
				throw new BadCredentialsException("Este usuário está desativado.");
			}
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado. O seu token pode estar inválido.");
		}
	}

	@Override
	public void validaColunaUnica(User entity) {
		Collection<User> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getUsername(), i.getUsername());
		});

	}

	@Override
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
