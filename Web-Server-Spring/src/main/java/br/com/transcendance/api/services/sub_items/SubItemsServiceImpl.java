package br.com.transcendance.api.services.sub_items;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.sub_items.SubItems;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.sub_items.SubItemsRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class SubItemsServiceImpl extends AbstractBaseRepositoryImpl<SubItems, Long>
		implements SubItemsService {

	private SubItemsRepository myDomainRepository;

	public SubItemsServiceImpl(SubItemsRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(SubItems entity) {
		Collection<SubItems> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	@Override
	public Collection<SubItems> findByItemsId(long items_Id) {
		return myDomainRepository.findByItemsId(items_Id);
	}

	// @Override
	public Page<SubItems> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
