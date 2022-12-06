package br.com.transcendance.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@PropertySource("classpath:messages.properties")
@Data
public class MessageUtil {

	// log error

	@Value("${error.generico}")
	private String erroGenerico;

	@Value("${error.salvar}")
	private String erroSalvar;

	@Value("${error.alterar}")
	private String erroAlterar;

	@Value("${error.delete}")
	private String erroDelete;

	@Value("${error.inactive}")
	private String erroInactive;

	@Value("${error.buscar}")
	private String erroBuscar;

	@Value("${error.buscar.todas}")
	private String erroBuscarTodas;

	@Value("${error.acessonegado}")
	private String erroAcessoNegado;

	@Value("${error.vencedor}")
	private String erroVencedor;

	@Value("${erro.valortotalpedidomae}")
	private String erroValorTotalPedidoMae;

	@Value("${error.logout}")
	private String errorLogout;

	@Value("${error.delete.demanda}")
	private String errorDeleteDemanda;

	@Value("${error.delete.demandaitens}")
	private String errorDeleteDemandaItens;

	@Value("${error.delete.cotacaoitens}")
	private String errorDeleteCotacaoItens;

	@Value("${error.copiar.demanda}")
	private String errorCopiarDemanda;

	@Value("${error.dataintegrityviolationexception}")
	private String errorDataIntegrityViolationException;

	@Value("${error.update.notafiscalitens}")
	private String errorUpdateNotaFiscalItens;

	// log info

	@Value("${info.salvar}")
	private String infoSalvar;

	@Value("${info.alterar}")
	private String infoAlterar;

	@Value("${info.inativar}")
	private String infoInativar;

	@Value("${info.deletar}")
	private String infoDeletar;

	@Value("${info.login.auth}")
	private String infoLogin;

	@Value("${info.login.bad}")
	private String infoLoginBad;

	@Value("${info.buscar}")
	private String infoBuscar;

	@Value("${info.buscar.todas}")
	private String infoBuscarTodas;

	@Value("${info.buscar.cidadeuf}")
	private String infoBuscarCidadeUf;

	@Value("${info.buscar.ufporpais}")
	private String infoBuscarUfPorPais;

	@Value("${info.buscar.demandaporsafra}")
	private String infoBuscarDemandaPorSafra;

	@Value("${info.buscar.quantidadedemandadaProduto}")
	private String infoBuscarQuantidadedemandadaProduto;

	@Value("${info.buscar.CotacaoItensNaoEncerradas}")
	private String infoBuscarCotacaoItensNaoEncerradas;

	@Value("${info.vencedor}")
	private String infoVencedor;

	@Value("${info.regranegocio.vencedor}")
	private String infoRegraNegocioVencedor;

	@Value("${info.cancelar.notafiscal}")
	private String infoCancelarNotaFiscal;

	@Value("${info.atualizar.notafiscalitens}")
	private String infoAtualizarNotaFiscalItens;

	@Value("${info.buscar.valortotalordemcompra}")
	private String infoBuscarValorTotalOrdemCompra;

	@Value("$info.cancelar.ordemcompra}")
	private String infoCancelarOrdemCompra;

	@Value("${info.buscar.quantidadedisponivelproduto}")
	private String infoBuscarQuantidadeDisponivelProduto;

	@Value("${info.atualizar.updatequantidadecompra}")
	private String infoAtualizarUpdateQuantidadeCompra;

	@Value("${info.regranegocio.ordemcompra}")
	private String infoRegraNegocioOrdemCompra;

	@Value("${info.cancelar.pedidocompra}")
	private String infoCancelarPedidoCompra;

	@Value("${info.gerar.pedidomae}")
	private String infoGerarPedidoMae;

	@Value("${info.regranegocio.pedidomae}")
	private String infoRegraNegocioPedidoMae;

	@Value("${info.cancelar.pedidomae}")
	private String infoCancelarPedidoMae;

	@Value("${info.calcular.valortotalpedidomae}")
	private String infoCalcularValorTotalPedidoMae;

	@Value("${info.buscar.contratoporgrupofamiliar}")
	private String infoBuscarContratoPorGrupoFamiliar;

	@Value("${info.buscar.contratoparcelaporcontrato}")
	private String infoBuscarContratoParcelaPorContrato;

	@Value("${info.atualizar.contratoparcela}")
	private String infoAtualizarContratoParcela;

	@Value("${info.usuario.findByToken}")
	private String infoUsuarioFindByToken;

	@Value("${info.logout}")
	private String infoLogout;

	@Value("${info.buscar.parcelacontaspagar}")
	private String infoBuscarParcelaContasPagar;

	@Value("${info.copiar.demanda}")
	private String infoCopiarDemanda;

	@Value("${info.buscar.listagemparcelascontaspagarfiltro}")
	private String infoBuscaListagemParcelasContasPagarFiltro;

	@Value("${info.erepique}")
	private String infoERepique;

	@Value("${info.ordemcompra.gerarfinanceiro}")
	private String infoOrdemCompraGerarFinanceiro;

	@Value("${info.ordemcompra.temfinanceiro}")
	private String infoOrdemCompraTemFinanceiro;

	@Value("${info.buscar.produtoresbygrupofamiliar}")
	private String infoBuscarProdutoresByGrupoFamiliar;

	// log info sucesso

	@Value("${info.salvar.sucesso}")
	private String infoSalvarSucesso;

	@Value("${info.alterar.sucesso}")
	private String infoAlterarSucesso;

	@Value("${info.delete.sucesso}")
	private String infoDeletarSucesso;

	@Value("${info.inactive.sucesso}")
	private String infoInativarSucesso;

	@Value("${info.buscar.sucesso}")
	private String infoBuscarSucesso;

	@Value("${info.buscar.todas.sucesso}")
	private String infoBuscarTodasSucesso;

	@Value("${info.buscar.cidadeuf.sucesso}")
	private String infoBuscarCidadeUfSucesso;

	@Value("${info.buscar.ufporpais.sucesso}")
	private String infoBuscarUfPorPaisSucesso;

	@Value("${info.buscar.demandaporsafra.sucesso}")
	private String infoBuscarDemandaPorSafraSucesso;

	@Value("${info.buscar.quantidadedemandadaProduto.sucesso}")
	private String infoBuscarQuantidadedemandadaProdutoSucesso;

	@Value("${info.buscar.CotacaoItensNaoEncerradas.sucesso}")
	private String infoBuscarCotacaoItensNaoEncerradasSucesso;

	@Value("${info.vencedor.sucesso}")
	private String infoVencedorSucesso;

	@Value("${info.cancelar.notafiscal.sucesso}")
	private String infoCancelarNotaFiscalSucesso;

	@Value("${info.atualizar.notafiscalitens.sucesso}")
	private String infoAtualizarNotaFiscalItensSucesso;

	@Value("${info.buscar.valortotalordemcompra.sucesso}")
	private String infoBuscarValorTotalOrdemCompraSucesso;

	@Value("$info.cancelar.ordemcompra.sucesso}")
	private String infoCancelarOrdemCompraSucesso;

	@Value("${info.buscar.quantidadedisponivelproduto.sucesso}")
	private String infoBuscarQuantidadeDisponivelProdutoSucesso;

	@Value("${info.atualizar.updatequantidadecompra.sucesso}")
	private String infoAtualizarUpdateQuantidadeCompraSucesso;

	@Value("${info.cancelar.pedidocompra.sucesso}")
	private String infoCancelarPedidoCompraSucesso;

	@Value("${info.gerar.pedidomae.sucesso}")
	private String infoGerarPedidoMaeSucesso;

	@Value("${info.cancelar.pedidomae.sucesso}")
	private String infoCancelarPedidoMaeSucesso;

	@Value("${info.calcular.valortotalpedidomae.sucesso}")
	private String infoCalcularValorTotalPedidoMaeSucesso;

	@Value("${info.buscar.contratoporgrupofamiliar.sucesso}")
	private String infoBuscarContratoPorGrupoFamiliarSucesso;

	@Value("${info.buscar.contratoparcelaporcontrato.sucesso}")
	private String infoBuscarContratoParcelaPorContratoSucesso;

	@Value("${info.atualizar.contratoparcela.sucesso}")
	private String infoAtualizarContratoParcelaSucesso;

	@Value("${info.usuario.findByToken.sucesso}")
	private String infoUsuarioFindByTokenSucesso;

	@Value("${info.logout.sucesso}")
	private String infoLogoutSucesso;

	@Value("${info.login.sucesso}")
	private String infoLoginSucesso;

	@Value("${info.buscar.parcelacontaspagar.sucesso}")
	private String infoBuscarParcelaContasPagarSucesso;

	@Value("${info.copiar.demanda.sucesso}")
	private String infoCopiarDemandaSucesso;

	@Value("${info.buscar.listagemparcelascontaspagarfiltro.sucesso}")
	private String infoBuscaListagemParcelasContasPagarFiltroSucesso;

	@Value("${info.ordemcompra.gerarfinanceiro.sucesso}")
	private String infoOrdemCompraGerarFinanceiroSucesso;

	@Value("${info.ordemcompra.temfinanceiro.sucesso}")
	private String infoOrdemCompraTemFinanceiroSucesso;

	@Value("${info.erepique.sucesso}")
	private String infoERepiqueSucesso;

	@Value("${info.buscar.produtoresbygrupofamiliar.sucesso}")
	private String infoBuscarProdutoresByGrupoFamiliarSucesso;

	// mensagens para o front

	@Value("${ip_nao_autorizado}")
	private String ipNaoAutorizado;

	@Value("${token_black_list}")
	private String tokenBlackList;

}
