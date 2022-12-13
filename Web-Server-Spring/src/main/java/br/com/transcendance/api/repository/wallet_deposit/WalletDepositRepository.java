package br.com.transcendance.api.repository.wallet_deposit;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.wallet_deposit.WalletDeposit;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface WalletDepositRepository extends AbstractBaseRepository<WalletDeposit, Long> {

	Collection<WalletDeposit> findByWalletId(long wallet_Id);

}
