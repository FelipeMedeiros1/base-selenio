package SISTEMA.relatorios.patrimonio.carteira_diaria;

import SISTEMA.utils.UtilitarioRelatorioTestCase;
import SISTEMA.propriedades.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.relatorios.patrimonio.CarteiraDiariaPage;

public class CarteiraDiariaUtils extends UtilitarioRelatorioTestCase<CarteiraDiaria,CarteiraDiariaPage> {

    public CarteiraDiariaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CarteiraDiariaPage page, CarteiraDiaria modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(),chavePrimaria,"CarteiraDiaria", CarteiraDiaria.class);

        page.dataInicio(modeloDeCadastro.getDataInicio());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        page.tipoDePosicao(modeloDeCadastro.getTipoDePosicao());
        page.tipoDeConsolidacao(modeloDeCadastro.getTipoDeConsolidacao());
        page.custoMedio(modeloDeCadastro.getCustoMedio());
        page.carteira(modeloDeCadastro.getCarteira());
        page.tipoDoRelatorio(modeloDeCadastro.getTipoDoRelatorio());
        page.saida(modeloDeCadastro.getSaida());
    }
    @Override
    public CarteiraDiariaUtils gerarRelatorio(CarteiraDiaria modeloDeCadastro, String chavePrimaria){
        CarteiraDiariaPage page = new CarteiraDiariaPage();
        page.acessaPagina();
        preencheDados(page,modeloDeCadastro,chavePrimaria);
        page.confirmar();

        return this;

    }
}
