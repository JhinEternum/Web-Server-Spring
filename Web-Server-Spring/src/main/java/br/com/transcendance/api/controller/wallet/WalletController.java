package br.com.transcendance.api.controller.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.transcendance.api.controller.AbstractController;
import br.com.transcendance.api.models.wallet.Wallet;
import br.com.transcendance.api.services.wallet.WalletService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/wallet")
public class WalletController extends AbstractController<Wallet, Long> {
    private WalletService service;

    @Autowired
    public WalletController(WalletService service) {
        super(service);
        this.service = service;
    }

}
