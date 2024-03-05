package SISTEMA.relatorios.patrimonio.carteira_diaria;

import SISTEMA.config.servicos.utils.UtilitarioRelatorioTestCase;
import SISTEMA.config.servicos.leitorplanilha.LeitorPlanilha;
import WEBDRIVER.pageObject.relatorios.patrimonio.CarteiraDiariaPage;

import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.adicionarLogDeFalha;
import static SISTEMA.config.servicos.utils.RelatorioEvidenciaDeTeste.evidencia;

public class CarteiraDiariaUtils extends UtilitarioRelatorioTestCase<CarteiraDiaria, CarteiraDiariaPage> {

    public CarteiraDiariaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CarteiraDiariaPage page, CarteiraDiaria modeloDeCadastro, String chavePrimaria) {
        modeloDeCadastro = LeitorPlanilha.carregarDados(getNomeDaPlanilha(), chavePrimaria, "CarteiraDiaria", CarteiraDiaria.class);

        page.dataInicio(modeloDeCadastro.getDataInicio());
        page.dataFinal(modeloDeCadastro.getDataFinal());
        evidencia("CarteiraDiaria","data");
        page.tipoDePosicao(modeloDeCadastro.getTipoDePosicao());
        page.tipoDeConsolidacao(modeloDeCadastro.getTipoDeConsolidacao());
        page.custoMedio(modeloDeCadastro.getCustoMedio());
        page.carteira(modeloDeCadastro.getCarteira());
        evidencia("CarteiraDiaria","carteira");
        page.tipoDoRelatorio(modeloDeCadastro.getTipoDoRelatorio());
        evidencia("CarteiraDiaria","tipoDoRelatorio");
        page.saida(modeloDeCadastro.getSaida());
    }

    @Override
    public CarteiraDiariaUtils gerarRelatorio(CarteiraDiaria modeloDeCadastro, String chavePrimaria) {
        try {
            CarteiraDiariaPage page = new CarteiraDiariaPage();
            page.acessaPagina();
            preencheDados(page, modeloDeCadastro, chavePrimaria);
            page.confirmar("CarteiraDiaria");

        } catch (Exception e) {
            e.printStackTrace();
            adicionarLogDeFalha("CarteiraDiaria");
        }
        return this;

    }
}
