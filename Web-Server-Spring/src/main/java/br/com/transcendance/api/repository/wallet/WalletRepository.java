package br.com.transcendance.api.repository.wallet;

import org.springframework.stereotype.Repository;

import br.com.transcendance.api.models.wallet.Wallet;
import br.com.transcendance.api.repository.AbstractBaseRepository;

@Repository
public interface WalletRepository extends AbstractBaseRepository<Wallet, Long> {

	// List<Endereco> findByPessoaId(Long produtorId);

}
