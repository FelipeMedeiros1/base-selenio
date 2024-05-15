package sistema.dominio.transacoes.cadastro_pessoas.renda_variavel;

import webdriver.base.BaseTest;
import webdriver.pages.transacoes.cadastro_pessoas.renda_variavel.CadastroRendaVariavelPage;
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
