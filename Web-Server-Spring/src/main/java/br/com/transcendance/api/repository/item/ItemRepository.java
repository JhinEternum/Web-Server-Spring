package br.com.transcendance.api.repository.item;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.item.Item;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface ItemRepository extends AbstractBaseRepository<Item, Long> {

	Collection<Item> findByCharacterId(Long character_id);

}
