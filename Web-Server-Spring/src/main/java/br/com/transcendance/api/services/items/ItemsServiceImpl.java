package br.com.transcendance.api.services.items;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.items.Items;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.items.ItemsRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class ItemsServiceImpl extends AbstractBaseRepositoryImpl<Items, Long>
		implements ItemsService {

	private ItemsRepository myDomainRepository;

	public ItemsServiceImpl(ItemsRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(Items entity) {
		Collection<Items> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	// @Override
	public Page<Items> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
