package SISTEMA.transacoes.fundos.movimentacao;

import SISTEMA.base.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.transacoes.fundos.movimentacao.MovimentacaoPage;

public class MovimentacaoFdsUtils extends UtilitarioCadastroTestCase<Movimentacao, MovimentacaoPage> {
    public MovimentacaoFdsUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(MovimentacaoPage page, Movimentacao modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "Movimentacao", Movimentacao.class);
        page.dataDoMovimento(modeloDeCadastro.getDataDoMovimento());
        page.carteira(modeloDeCadastro.getCarteira());
        page.fundo(modeloDeCadastro.getFundo());
        page.modalidadeDoMovimento(modeloDeCadastro.getModalidadeDoMovimento());
        page.subsegmentoPREVIC(modeloDeCadastro.getSubsegmentoPREVIC());
        page.dataDaAplicacao(modeloDeCadastro.getDataDaAplicacao());
        page.dataDeCotizacao(modeloDeCadastro.getDataDeCotizacao());
        page.liquidacaoDoMovimento(modeloDeCadastro.getLiquidacaoDoMovimento());
        if (modeloDeCadastro.getEstoque() != "" || modeloDeCadastro.getEstoque() != null) {
            page.estoque(modeloDeCadastro.getEstoque());
        }
        page.quantidade(modeloDeCadastro.getQuantidade());
        page.financeiro(modeloDeCadastro.getFinanceiro());

    }

    @Override
    public MovimentacaoFdsUtils iniciarTeste(Movimentacao modeloDeCadastro, String chavePrimaria) {
        MovimentacaoPage page = new MovimentacaoPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.confirmaOperacao();

        return this;
    }
}
