package br.com.transcendance.api.repository.character;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.character.CharacterProficiency;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface CharacterProficiencyRepository extends AbstractBaseRepository<CharacterProficiency, Long> {

	Collection<CharacterProficiency> findByCharacterId(Long character_id);

}
