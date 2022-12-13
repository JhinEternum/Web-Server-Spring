package br.com.transcendance.api.models.wallet_deposit;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.com.transcendance.api.models.AbstractBaseEntity;
import br.com.transcendance.api.models.wallet.Wallet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WalletDeposit extends AbstractBaseEntity {
    private static final long serialVersionUID = 1L;

    private Double money;

    @ManyToOne
    @JoinColumn(name = "wallet_id", nullable = false)
    private Wallet wallet;

}