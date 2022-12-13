package br.com.transcendance.api.services.character;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.character.CharacterType;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.character.CharacterTypeRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class CharacterTypeServiceImpl extends AbstractBaseRepositoryImpl<CharacterType, Long>
		implements CharacterTypeService {

	private CharacterTypeRepository myDomainRepository;

	public CharacterTypeServiceImpl(CharacterTypeRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(CharacterType entity) {
		Collection<CharacterType> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	// @Override
	public Page<CharacterType> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
