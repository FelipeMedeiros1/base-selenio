package SISTEMA.relatorios.patrimonio.carteira_diaria;

import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import SISTEMA.propriedades.valida_csv.ValidaArquivo;
import WEBDRIVER.pageObject.relatorios.patrimonio.CarteiraDiariaPage;

public class CarteiraDiariaUtils {
    private String repositorioTeste;
    public CarteiraDiariaUtils(String repositorioTeste) {
        this.repositorioTeste = repositorioTeste;
    }
    public CarteiraDiariaUtils gerarRelatorio(CarteiraDiaria modeloDeCadastro, String chavePrimaria){
        modeloDeCadastro =
                LeitorPlanilha.carregarDados(repositorioTeste,chavePrimaria,"CarteiraDiaria", CarteiraDiaria.class);
        CarteiraDiariaPage page = new CarteiraDiariaPage();
        page.acessaPaginaCarteiraDiaria();
        page.dataInicio(modeloDeCadastro.getDataInicio());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.tipoDePosicao(modeloDeCadastro.getTipoDePosicao());
        page.tipoDeConsolidacao(modeloDeCadastro.getTipoDeConsolidacao());
        page.custoMedio(modeloDeCadastro.getCustoMedio());
        page.carteira(modeloDeCadastro.getCarteira());
        page.tipoDoRelatorio(modeloDeCadastro.getTipoDoRelatorio());
        page.saida(modeloDeCadastro.getSaida());
        page.confirmar();
//        ValidaArquivo.validaCSV(modeloDeCadastro.getNomeArquivo());

        return this;

    }
}
