package SISTEMA.relatorios.renda_fixa.movimentacao;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.relatorios.renda_fixa.MovimentacaoPage;

public class MovimentacaoUtils {
    private String repositorioTeste;

    public MovimentacaoUtils(String repositorioTeste) {
        this.repositorioTeste = repositorioTeste;
    }
    public void gerarRelatorio(Movimentacao modeloDeCadastro,String chavePrimaria){
        modeloDeCadastro = LeitorPlanilha.carregarDados(repositorioTeste,chavePrimaria,"Movimentacao", Movimentacao.class);
        MovimentacaoPage page = new MovimentacaoPage();
        page.acessaPaginaRelMovimentacao();
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
        page.confirmar();

    }

}
