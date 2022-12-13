package br.com.transcendance.api.repository.character;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.character.CharacterLevel;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface CharacterLevelRepository extends AbstractBaseRepository<CharacterLevel, Long> {

	// List<Endereco> findByPessoaId(Long produtorId);

}
