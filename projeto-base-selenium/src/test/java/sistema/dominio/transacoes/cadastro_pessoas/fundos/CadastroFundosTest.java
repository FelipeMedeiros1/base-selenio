package sistema.dominio.transacoes.cadastro_pessoas.fundos;

import webdriver.base.BaseTest;
import webdriver.pages.transacoes.cadastro_pessoas.fundos.CadastroFundosPage;
import org.junit.Test;

public class CadastroFundosTest extends BaseTest {
    @Test
    public void testCadastrarFundos(){
        CadastroFundosPage fds = new CadastroFundosPage();
        fds.acessaPaginaFundos()
                .carteira("FELIPE - JSM")
                .formaDeCondominio("Aberto")
                .tipoDeFundos("Fundo de Investimento")
                .confirmaOperacao("Cadastro-fundo");
    }
}
