package SISTEMA.transacoes.renda_fixa.operacoesdefinitivas;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.renda_fixa.operacoesdefinitivas.OperacoesDefinitivasPage;

public class OperacoesDefinitivasUtils {
    private final String nomeDaClasse;

    public OperacoesDefinitivasUtils(String caminhoPlanilha) {
        this.nomeDaClasse = caminhoPlanilha;
    }

    public OperacoesDefinitivasUtils incluir(OperacoesDefinitivas modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(nomeDaClasse, chavePrimaria, "OperacoesDefinitivas", OperacoesDefinitivas.class);
        OperacoesDefinitivasPage page = new OperacoesDefinitivasPage();
        page.aceesaPaginaOperacoesDefinitivas();
        page.modalidadeDoMovimento(modeloDeCadastro.getModalidadeDomovimento());
        page.dataDoMovimento(modeloDeCadastro.getDataDoMovimento());
        page.dataDaCompra(modeloDeCadastro.getDataDaCompra());
        page.carteira(modeloDeCadastro.getCarteira());
        page.titulo(modeloDeCadastro.getTitulo());
        page.emissao(modeloDeCadastro.getEmissao());
        page.estoque(modeloDeCadastro.getEstoque());
        page.ativaPassiva(modeloDeCadastro.getAtivaPassiva());
        page.categoria(modeloDeCadastro.getCategoria());
        page.riscoBeneficio(modeloDeCadastro.getRiscoBeneficio());
        page.condicoesDeNegociacao(modeloDeCadastro.getCondicoesDeNegociacao());
        page.pu(modeloDeCadastro.getPu());
        page.quantidade(modeloDeCadastro.getQuantidade());
        page.eventoEmAtraso(modeloDeCadastro.getEventoEmAtraso());

    return this;
    }
}
