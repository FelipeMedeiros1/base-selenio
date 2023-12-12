package SISTEMA.transacoes.cadastro_pessoas.fundos;

import WEBDRIVER.base.baseTest.BaseTest;
import WEBDRIVER.pageObject.transacoes.cadastro_pessoas.fundos.CadastroFundosPage;
import org.junit.Test;

public class CadastroFundosTest extends BaseTest {
    @Test
    public void testCadastrarFundos(){
        CadastroFundosPage fds = new CadastroFundosPage();
        fds.acessaPaginaFundos()
                .carteira("FELIPE - JSM")
                .formaDeCondominio("Aberto")
                .tipoDeFundos("Fundo de Investimento")
                .confirmaOperacao();
    }
}
