package SISTEMA.transacoes.cadastro_basico.moedas;

import WEBDRIVER.base.BaseTest;
import WEBDRIVER.pageObject.transacoes.cadastros_basicos.moedas.MoedaAlteracaoPage;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoedasTest extends BaseTest {
    private Moedas moedas;

    @Test
    public void test01_cadastrarMoeda() {

        new MoedasUtils("MoedasTest").incluir(moedas,"M1");
    }
    @Test
    public void test02_alterarMoeda() {
        MoedaAlteracaoPage page = new MoedaAlteracaoPage();
        page.acessaPaginaMoedasAlteracao()
                .codigoPesquisa("123456")
                .selecionaGrid(0).clicarGrid()
                .alterar();
        page.codigo("654321")
                .nome("FelipeMedeiros")
                .simbolo("1407")
                .confirmaOperacao();
    }
    @Test
    public void test03_excluirMoeda() {
        new MoedasUtils("MoedasTest").excluir("654321");
    }
  }
