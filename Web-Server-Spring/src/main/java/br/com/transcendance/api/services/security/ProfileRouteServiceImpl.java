package br.com.transcendance.api.services.security;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.security.ProfileRoute;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.secutity.ProfileRouteRepository;

@Service
@Transactional
public class ProfileRouteServiceImpl extends AbstractBaseRepositoryImpl<ProfileRoute, Long>
		implements ProfileRouteService {

	private ProfileRouteRepository myDomainRepository;

	public ProfileRouteServiceImpl(ProfileRouteRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	@Override
	public Collection<ProfileRoute> findByRouteId(Long routeId) {
		return myDomainRepository.findByRouteId(routeId);
	}

	@Override
	public void validaColunaUnica(ProfileRoute entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public Page<ProfileRoute> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
