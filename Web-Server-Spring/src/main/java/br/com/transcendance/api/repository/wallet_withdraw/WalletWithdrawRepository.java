package br.com.transcendance.api.repository.wallet_withdraw;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.wallet_withdraw.WalletWithdraw;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface WalletWithdrawRepository extends AbstractBaseRepository<WalletWithdraw, Long> {

	Collection<WalletWithdraw> findByWalletId(long wallet_Id);

}
