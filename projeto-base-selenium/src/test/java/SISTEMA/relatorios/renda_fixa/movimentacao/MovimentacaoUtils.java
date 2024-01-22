package SISTEMA.relatorios.renda_fixa.movimentacao;

import SISTEMA.propriedades.utils.UtilitarioRelatorioTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.relatorios.renda_fixa.movimentacao.MovimentacaoPage;

public class MovimentacaoUtils extends UtilitarioRelatorioTestCase<Movimentacao,MovimentacaoPage> {
    public MovimentacaoUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }
    @Override
    protected void preencheDados(MovimentacaoPage page, Movimentacao modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(),chavePrimaria,"MovimentacaoFds", Movimentacao.class);
        page.dataInicio(modeloDeCadastro.getDataInicio());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.modalidadeDeMovimento(modeloDeCadastro.getModalidadeDeMovimento());
        page.titulo(modeloDeCadastro.getTitulo());
        page.emissao(modeloDeCadastro.getEmissao());
        page.carteira(modeloDeCadastro.getCarteira());
        page.saida(modeloDeCadastro.getSaida());
        page.idioma(modeloDeCadastro.getIdioma());
        page.moeda(modeloDeCadastro.getMoeda());
        page.tipoRelatorio(modeloDeCadastro.getTipoRelatorio());
    }
    @Override
    protected MovimentacaoUtils gerarRelatorio(Movimentacao modeloDeCadastro, String chavePrimaria) {
        MovimentacaoPage page = new MovimentacaoPage();
        page.acessaPagina();
        preencheDados(page,modeloDeCadastro,chavePrimaria);
        page.confirmar();

        return this;
    }
}
