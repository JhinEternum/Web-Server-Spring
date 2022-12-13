package br.com.transcendance.api.services.wallet_deposit;

import java.util.Collection;

import br.com.transcendance.api.models.wallet_deposit.WalletDeposit;
import br.com.transcendance.api.services.AbstractBaseService;

public interface WalletDepositService extends AbstractBaseService<WalletDeposit, Long> {
    Collection<WalletDeposit> findByWalletId(long wallet_Id);
}
