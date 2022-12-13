package br.com.transcendance.api.repository.sub_items;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.sub_items.SubItems;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface SubItemsRepository extends AbstractBaseRepository<SubItems, Long> {

	public Collection<SubItems> findByItemsId(long items_Id);

}
