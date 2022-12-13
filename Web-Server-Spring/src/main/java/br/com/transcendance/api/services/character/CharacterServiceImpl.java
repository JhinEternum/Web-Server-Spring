package br.com.transcendance.api.services.character;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.character.Character;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.character.CharacterRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class CharacterServiceImpl extends AbstractBaseRepositoryImpl<Character, Long>
		implements CharacterService {

	private CharacterRepository myDomainRepository;

	public CharacterServiceImpl(CharacterRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(Character entity) {
		Collection<Character> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	// @Override
	public Page<Character> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
