package br.com.transcendance.api.services.proficiency;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.proficiency.Proficiency;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.proficiency.ProficiencyRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class ProficiencyServiceImpl extends AbstractBaseRepositoryImpl<Proficiency, Long>
		implements ProficiencyService {

	private ProficiencyRepository myDomainRepository;

	public ProficiencyServiceImpl(ProficiencyRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(Proficiency entity) {
		Collection<Proficiency> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	// @Override
	public Page<Proficiency> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public Collection<Proficiency> findByCharacterId(Long character_id) {
	// return myDomainRepository.findByCharacterId(character_id);
	// }

}
