package br.com.transcendance.api.services.character;

import java.util.Collection;

import br.com.transcendance.api.models.character.CharacterProficiency;
import br.com.transcendance.api.services.AbstractBaseService;

public interface CharacterProficiencyService extends AbstractBaseService<CharacterProficiency, Long> {
    Collection<CharacterProficiency> findByCharacterId(Long character_id);
}
