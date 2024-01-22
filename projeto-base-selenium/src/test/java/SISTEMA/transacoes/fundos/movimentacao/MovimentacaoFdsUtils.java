package SISTEMA.transacoes.fundos.movimentacao;

import SISTEMA.propriedades.utils.UtilitarioCadastroTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.componentes.CapturaDeTela;
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
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-dataDoMovimento");
        page.carteira(modeloDeCadastro.getCarteira());
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-carteira");
        page.fundo(modeloDeCadastro.getFundo());
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-fundo");
        page.modalidadeDoMovimento(modeloDeCadastro.getModalidadeDoMovimento());
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-modalidadeDoMovimento");
        page.subsegmentoPREVIC(modeloDeCadastro.getSubsegmentoPREVIC());
        page.dataDaAplicacao(modeloDeCadastro.getDataDaAplicacao());
        page.dataDeCotizacao(modeloDeCadastro.getDataDeCotizacao());
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-dataDeCotizacao");
        page.liquidacaoDoMovimento(modeloDeCadastro.getLiquidacaoDoMovimento());
        if (modeloDeCadastro.getEstoque() != "" || modeloDeCadastro.getEstoque() != null) {
            page.estoque(modeloDeCadastro.getEstoque());
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-estoque");
        }
        page.quantidade(modeloDeCadastro.getQuantidade());
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-quantidade");
        page.financeiro(modeloDeCadastro.getFinanceiro());
        new CapturaDeTela().evidencia("Movimentacao","preenchendo-financeiro");

    }

    @Override
    public MovimentacaoFdsUtils executarTeste(Movimentacao modeloDeCadastro, String chavePrimaria) {
        MovimentacaoPage page = new MovimentacaoPage();
        page.acessaPagina();
        preencheDados(page, modeloDeCadastro, chavePrimaria);
        page.confirmaOperacao("Movimentacao");

        return this;
    }
}
