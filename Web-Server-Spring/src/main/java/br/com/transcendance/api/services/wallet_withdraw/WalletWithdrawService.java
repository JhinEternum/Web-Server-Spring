package br.com.transcendance.api.services.wallet_withdraw;

import java.util.Collection;

import br.com.transcendance.api.models.wallet_withdraw.WalletWithdraw;
import br.com.transcendance.api.services.AbstractBaseService;

public interface WalletWithdrawService extends AbstractBaseService<WalletWithdraw, Long> {
    Collection<WalletWithdraw> findByWalletId(long wallet_Id);
}
