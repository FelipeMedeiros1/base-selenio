package SISTEMA.relatorios.renda_fixa.rendimentos;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.relatorios.renda_fixa.RendimentosPage;

public class RendimentosUtils {
    private String repositorioTeste;

    public RendimentosUtils(String repositorioTeste) {
        this.repositorioTeste = repositorioTeste;
    }
    public RendimentosUtils gerarRelatorio(Rendimentos modeloDeCadastro, String chavePrimaria){
        modeloDeCadastro = LeitorPlanilha.carregarDados(repositorioTeste,chavePrimaria,"Rendimentos",Rendimentos.class);
        RendimentosPage page = new RendimentosPage();
        page.acessarPaginaRelRendimentos();
        page.dataInicial(modeloDeCadastro.getDataInicial());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.carteira(modeloDeCadastro.getCarteira());
        page.saida(modeloDeCadastro.getSaida());
        page.moeda(modeloDeCadastro.getMoeda());
        page.confirmar();

        return this;
    }

}
