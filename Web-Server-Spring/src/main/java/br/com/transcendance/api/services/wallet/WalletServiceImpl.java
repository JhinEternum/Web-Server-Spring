package br.com.transcendance.api.services.wallet;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.wallet.Wallet;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.wallet.WalletRepository;
import br.com.transcendance.api.util.ModelUtil;

@Service
@Transactional
public class WalletServiceImpl extends AbstractBaseRepositoryImpl<Wallet, Long>
		implements WalletService {

	private WalletRepository myDomainRepository;

	public WalletServiceImpl(WalletRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	// @Override
	public void validaColunaUnica(Wallet entity) {
		Collection<Wallet> collection = this.findAll();

		collection.stream().forEach(i -> {
			ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(), i.getName());
		});

	}

	// @Override
	public Page<Wallet> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
