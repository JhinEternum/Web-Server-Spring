package br.com.transcendance.api.repository.person;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.person.Uf;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface UfRepository extends AbstractBaseRepository<Uf, Long> {

	// Collection<Uf> findByPaisId(Long paisId);
	// List<Endereco> findByPessoaId(Long produtorId);

}
