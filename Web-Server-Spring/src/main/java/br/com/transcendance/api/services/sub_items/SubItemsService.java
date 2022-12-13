package br.com.transcendance.api.services.sub_items;

import java.util.Collection;

import br.com.transcendance.api.models.sub_items.SubItems;
import br.com.transcendance.api.services.AbstractBaseService;

public interface SubItemsService extends AbstractBaseService<SubItems, Long> {
    public Collection<SubItems> findByItemsId(long items_Id);
}
