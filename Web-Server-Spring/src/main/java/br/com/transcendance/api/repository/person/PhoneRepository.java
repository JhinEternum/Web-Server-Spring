package br.com.transcendance.api.repository.person;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.person.Phone;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface PhoneRepository extends AbstractBaseRepository<Phone, Long> {

	// List<Endereco> findByPessoaId(Long produtorId);

}
