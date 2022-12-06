package br.com.transcendance.api.repository.person;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.person.City;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface CityRepository extends AbstractBaseRepository<City, Long> {

	Collection<City> findByUfId(Long ufId);
	// List<Endereco> findByPessoaId(Long produtorId);

}
