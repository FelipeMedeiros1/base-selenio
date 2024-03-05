package SISTEMA.transacoes.cadastro_pessoas.renda_variavel;

import WEBDRIVER.base.BaseTest;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.renda_variavel.CadastroRendaVariavelPage;
import org.junit.Test;

public class CadastroRendaVariavelTest extends BaseTest {

    @Test
    public void testCadastroRendaVariavel(){
        CadastroRendaVariavelPage rv = new CadastroRendaVariavelPage();
        rv.aceesaPaginaRendaVariavel()
                .carteira("")
                .confirmaOperacao();
    }
}
