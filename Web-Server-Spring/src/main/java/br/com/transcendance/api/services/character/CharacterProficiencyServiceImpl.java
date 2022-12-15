package br.com.transcendance.api.services.character;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.character.CharacterProficiency;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.character.CharacterProficiencyRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class CharacterProficiencyServiceImpl extends AbstractBaseRepositoryImpl<CharacterProficiency, Long>
		implements CharacterProficiencyService {

	private CharacterProficiencyRepository myDomainRepository;

	public CharacterProficiencyServiceImpl(CharacterProficiencyRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(CharacterProficiency entity) {
		Collection<CharacterProficiency> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getProficiency().getName(),
					i.getProficiency().getName());
		});

	}

	// @Override
	public Page<CharacterProficiency> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CharacterProficiency> findByCharacterId(Long character_id) {
		return myDomainRepository.findByCharacterId(character_id);
	}

}
