package br.com.transcendance.api.services.wallet_deposit;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.wallet_deposit.WalletDeposit;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.wallet_deposit.WalletDepositRepository;

@Service
@Transactional
public class WalletDepositServiceImpl extends AbstractBaseRepositoryImpl<WalletDeposit, Long>
		implements WalletDepositService {

	private WalletDepositRepository myDomainRepository;

	public WalletDepositServiceImpl(WalletDepositRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	@Override
	public Collection<WalletDeposit> findByWalletId(long wallet_Id) {
		return myDomainRepository.findByWalletId(wallet_Id);
	}

	// @Override
	public void validaColunaUnica(WalletDeposit entity) {
		Collection<WalletDeposit> collection = this.findAll();

		// collection.stream().forEach(i -> {
		// ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(),
		// i.getName());
		// });

	}

	// @Override
	public Page<WalletDeposit> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
