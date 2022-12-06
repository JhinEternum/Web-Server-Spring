package br.com.transcendance.api.repository.person;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.person.Person;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface PersonRepository extends AbstractBaseRepository<Person, Long> {

	// List<Endereco> findByPessoaId(Long produtorId);

}
