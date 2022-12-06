package br.com.transcendance.api.services.person;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.person.City;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.person.CityRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class CityServiceImpl extends AbstractBaseRepositoryImpl<City, Long>
		implements CityService {

	private CityRepository myDomainRepository;

	public CityServiceImpl(CityRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	@Override
	public void validaColunaUnica(City entity) {
		Collection<City> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	@Override
	public Page<City> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
