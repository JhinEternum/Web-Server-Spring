package br.com.transcendance.api.repository.character;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.character.Character;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface CharacterRepository extends AbstractBaseRepository<Character, Long> {

	// List<Endereco> findByPessoaId(Long produtorId);

}
