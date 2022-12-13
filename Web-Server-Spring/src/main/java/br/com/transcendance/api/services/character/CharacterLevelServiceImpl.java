package br.com.transcendance.api.services.character;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.character.CharacterLevel;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.character.CharacterLevelRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class CharacterLevelServiceImpl extends AbstractBaseRepositoryImpl<CharacterLevel, Long>
		implements CharacterLevelService {

	private CharacterLevelRepository myDomainRepository;

	public CharacterLevelServiceImpl(CharacterLevelRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(CharacterLevel entity) {
		Collection<CharacterLevel> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	// @Override
	public Page<CharacterLevel> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
