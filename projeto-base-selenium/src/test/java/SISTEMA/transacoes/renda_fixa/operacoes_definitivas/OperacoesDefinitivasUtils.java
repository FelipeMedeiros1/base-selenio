package SISTEMA.transacoes.renda_fixa.operacoes_definitivas;


import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;

import WEBDRIVER.pageObject.transacoes.renda_fixa.operacoes_definitivas.OperacoesDefinitivasPage;

public class OperacoesDefinitivasUtils extends UtilitarioCadastroTestCase<OperacoesDefinitivas, OperacoesDefinitivasPage> {

    public OperacoesDefinitivasUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }
    @Override
    protected void preencheDados(OperacoesDefinitivasPage page, OperacoesDefinitivas modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "OperacoesDefinitivas", OperacoesDefinitivas.class);
        page.dadosDaMovimentacao().modalidadeDoMovimento(modeloDeCadastro.getModalidadeDomovimento());
        page.dadosDaMovimentacao().dataDoMovimento(modeloDeCadastro.getDataDoMovimento());
        page.dadosDaMovimentacao().dataDaCompra(modeloDeCadastro.getDataDaCompra());
        page.dadosDaMovimentacao().carteira(modeloDeCadastro.getCarteira());
        page.dadosDaMovimentacao().titulo(modeloDeCadastro.getTitulo());
        page.dadosDaMovimentacao().emissao(modeloDeCadastro.getEmissao());
        if (modeloDeCadastro.getEstoque().equalsIgnoreCase("Venda config.properties Vista Coberta") || modeloDeCadastro.getEstoque().equalsIgnoreCase("Retirada config.properties Vista Coberta")){
        page.dadosDaMovimentacao().estoque(modeloDeCadastro.getEstoque());
        }
        page.dadosDaMovimentacao().ativaPassiva(modeloDeCadastro.getAtivaPassiva());
        page.dadosDaMovimentacao().categoria(modeloDeCadastro.getCategoria());
        page.dadosDaMovimentacao().riscoBeneficio(modeloDeCadastro.getRiscoBeneficio());
        if (!modeloDeCadastro.getCondicoesDeNegociacao().equalsIgnoreCase("")){
        page.dadosDaMovimentacao().condicoesDeNegociacao(modeloDeCadastro.getCondicoesDeNegociacao());
        }
        page.dadosDaMovimentacao().pu(modeloDeCadastro.getPu());
        page.dadosDaMovimentacao().quantidade(modeloDeCadastro.getQuantidade());
        page.dadosDaMovimentacao().calcular();
        page.dadosDaMovimentacao().financeiro(modeloDeCadastro.getFinanceiro());
        page.dadosDaMovimentacao().rendimento(modeloDeCadastro.getRendimento());
        page.dadosDaMovimentacao().eventoEmAtraso(modeloDeCadastro.getEventoEmAtraso());

    }
    @Override
    public OperacoesDefinitivasUtils executarTeste(OperacoesDefinitivas modeloDeCadastro, String chavePrimaria) {
        OperacoesDefinitivasPage page = new OperacoesDefinitivasPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro,chavePrimaria);
        page.confirmaOperacao();
        return this;
    }

}
