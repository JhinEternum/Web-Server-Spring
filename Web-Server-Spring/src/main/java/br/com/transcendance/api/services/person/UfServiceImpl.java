package br.com.transcendance.api.services.person;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.person.Uf;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.person.UfRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class UfServiceImpl extends AbstractBaseRepositoryImpl<Uf, Long>
		implements UfService {

	private UfRepository myDomainRepository;

	public UfServiceImpl(UfRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	@Override
	public void validaColunaUnica(Uf entity) {
		Collection<Uf> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	@Override
	public Page<Uf> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
