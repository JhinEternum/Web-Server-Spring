package br.com.transcendance.api.controller.wallet_withdraw;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.dto.AbstractDTO;
import br.com.transcendance.api.log.LogUtil;
import br.com.transcendance.api.models.Result;
import br.com.transcendance.api.models.wallet_withdraw.WalletWithdraw;
import br.com.transcendance.api.services.wallet_withdraw.WalletWithdrawService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/walletWithdraw")
public class WalletWithdrawController extends AbstractController<WalletWithdraw, Long> {
    private WalletWithdrawService service;

    @Autowired
    public WalletWithdrawController(WalletWithdrawService service) {
        super(service);
        this.service = service;
    }

    @RequestMapping(value = "/findByWallet", method = RequestMethod.POST)
    public ResponseEntity<Result> findByWalletId(@Valid @RequestBody AbstractDTO t) {

        Result result = new Result();

        try {
            log.info(LogUtil.formatMessageInfo("Searching for Wallet Withdraw by Wallet"));

            Collection<WalletWithdraw> list = service.findByWalletId(t.getId());

            log.info(LogUtil
                    .formatMessageInfo("Searching for Wallet Withdraw by Wallet success"));

            result.setMessage("Searching for Wallet Withdraw by Wallet success");
            result.setObject(list);
            result.setSuccess(true);

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            throw new EntityNotFoundException();
        }
    }

}
