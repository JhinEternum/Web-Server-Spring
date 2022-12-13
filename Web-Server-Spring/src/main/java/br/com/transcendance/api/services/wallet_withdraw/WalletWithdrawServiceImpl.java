package br.com.transcendance.api.services.wallet_withdraw;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.transcendance.api.models.wallet_withdraw.WalletWithdraw;
import br.com.transcendance.api.repository.AbstractBaseRepositoryImpl;
import br.com.transcendance.api.repository.wallet_withdraw.WalletWithdrawRepository;

@Service
@Transactional
public class WalletWithdrawServiceImpl extends AbstractBaseRepositoryImpl<WalletWithdraw, Long>
		implements WalletWithdrawService {

	private WalletWithdrawRepository myDomainRepository;

	public WalletWithdrawServiceImpl(WalletWithdrawRepository myDomainRepository) {
		super(myDomainRepository);
		this.myDomainRepository = myDomainRepository;
	}

	@Override
	public Collection<WalletWithdraw> findByWalletId(long wallet_Id) {
		return myDomainRepository.findByWalletId(wallet_Id);
	}

	// @Override
	public void validaColunaUnica(WalletWithdraw entity) {
		Collection<WalletWithdraw> collection = this.findAll();

		// collection.stream().forEach(i -> {
		// ModelUtil.validaColunaUnica(entity.getId(), i.getId(), entity.getName(),
		// i.getName());
		// });

	}

	// @Override
	public Page<WalletWithdraw> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}
