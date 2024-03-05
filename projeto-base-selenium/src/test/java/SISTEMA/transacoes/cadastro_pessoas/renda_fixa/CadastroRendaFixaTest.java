package SISTEMA.transacoes.cadastro_pessoas.renda_fixa;

import WEBDRIVER.base.BaseTest;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.renda_fixa.CadastroRendaFixaPage;
import org.junit.Test;

public class CadastroRendaFixaTest extends BaseTest {

    @Test
    public void testCadastroRendaFixa(){
        CadastroRendaFixaPage fix = new CadastroRendaFixaPage();
        fix.acessaPaginaRendaFixa()
                .carteira("FELIPE - JSM")
                .negociacaoAba().mtm("Não")
                .confirmaOperacao();

    }
}
