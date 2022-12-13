package br.com.transcendance.api.repository.character;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.character.CharacterType;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface CharacterTypeRepository extends AbstractBaseRepository<CharacterType, Long> {

	// List<Endereco> findByPessoaId(Long produtorId);

}
