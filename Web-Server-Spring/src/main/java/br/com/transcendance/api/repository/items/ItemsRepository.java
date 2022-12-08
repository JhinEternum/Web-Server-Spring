package br.com.transcendance.api.repository.items;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.items.Items;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface ItemsRepository extends AbstractBaseRepository<Items, Long> {

	// List<Endereco> findByPessoaId(Long produtorId);

}
