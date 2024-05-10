package SISTEMA.transacoes.fundos.movimentacao;


import SISTEMA.config.servicos.leitorDeArquivo.config_xls.LeitorXls;
import SISTEMA.config.servicos.utils.UtilitarioCadastroTestCase;

import WEBDRIVER.pageObject.transacoes.fundos.movimentacao.MovimentacaoPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.logDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;


public class MovimentacaoFdsUtils extends UtilitarioCadastroTestCase<Movimentacao, MovimentacaoPage> {
    public MovimentacaoFdsUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(MovimentacaoPage page, Movimentacao modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorXls.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Movimentacao", Movimentacao.class);
        page.dataDoMovimento(modeloDeCadastro.getDataDoMovimento());
        evidencia("Movimentacao","preenchendo-dataDoMovimento");
        page.carteira(modeloDeCadastro.getCarteira());
        evidencia("Movimentacao","preenchendo-carteira");
        page.fundo(modeloDeCadastro.getFundo());
        evidencia("Movimentacao","preenchendo-fundo");
        page.modalidadeDoMovimento(modeloDeCadastro.getModalidadeDoMovimento());
        evidencia("Movimentacao","preenchendo-modalidadeDoMovimento");
        page.subsegmentoPREVIC(modeloDeCadastro.getSubsegmentoPREVIC());
        page.dataDaAplicacao(modeloDeCadastro.getDataDaAplicacao());
        page.dataDeCotizacao(modeloDeCadastro.getDataDeCotizacao());
        evidencia("Movimentacao","preenchendo-dataDeCotizacao");
        page.liquidacaoDoMovimento(modeloDeCadastro.getLiquidacaoDoMovimento());
        if (modeloDeCadastro.getEstoque() != "" || modeloDeCadastro.getEstoque() != null) {
            page.estoque(modeloDeCadastro.getEstoque());
            evidencia("Movimentacao","preenchendo-estoque");
        }
        page.quantidade(modeloDeCadastro.getQuantidade());
        evidencia("Movimentacao","preenchendo-quantidade");
        page.financeiro(modeloDeCadastro.getFinanceiro());
        evidencia("Movimentacao","preenchendo-financeiro");

    }

    @Override
    public MovimentacaoFdsUtils executarTeste(Movimentacao modeloDeCadastro, String chavePrimaria) {
        try {
            MovimentacaoPage page = new MovimentacaoPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, chavePrimaria);
            page.confirmaOperacao("Movimentacao");

        } catch (Exception e) {
            e.printStackTrace();
            logDeFalha("Movimentacao");
        }
        return this;
    }
}
