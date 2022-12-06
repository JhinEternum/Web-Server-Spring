package br.com.transcendance.api.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.transcendance.api.models.AbstractBaseEntity;

@NoRepositoryBean
public interface AbstractBaseRepository<T extends AbstractBaseEntity, ID extends Serializable>
		extends JpaRepository<T, ID> {

	// Collection<T> findByProdutorId(Long pessoaId);
	// List<T> findAllOrderByIdDesc();
	// List<T> findAllOrderByDataCadastroDesc();

	// List<Person> findByLastnameOrderByFirstnameAsc(String lastname);

	List<T> findByOrderByIdDesc();

}
