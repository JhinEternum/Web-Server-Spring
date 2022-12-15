package br.com.transcendance.api.services.item;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.item.Item;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.item.ItemRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class ItemServiceImpl extends AbstractBaseRepositoryImpl<Item, Long>
		implements ItemService {

	private ItemRepository myDomainRepository;

	public ItemServiceImpl(ItemRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(Item entity) {
		Collection<Item> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	// @Override
	public Page<Item> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Item> findByCharacterId(Long character_id) {
		return myDomainRepository.findByCharacterId(character_id);
	}

}
