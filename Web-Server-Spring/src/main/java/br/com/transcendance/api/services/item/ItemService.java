package br.com.transcendance.api.services.item;

import java.util.Collection;

import br.com.transcendance.api.models.item.Item;
import br.com.transcendance.api.services.AbstractBaseService;

public interface ItemService extends AbstractBaseService<Item, Long> {
    Collection<Item> findByCharacterId(Long character_id);
}
