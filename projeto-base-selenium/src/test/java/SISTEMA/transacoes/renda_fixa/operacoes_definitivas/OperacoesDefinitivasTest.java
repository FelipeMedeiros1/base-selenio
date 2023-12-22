package SISTEMA.transacoes.renda_fixa.operacoes_definitivas;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class OperacoesDefinitivasTest extends BaseTest {
    private OperacoesDefinitivas opDefinitivas;
    @Test
    public void incluirOperacoesDefinitivas(){
        new OperacoesDefinitivasUtils("OperacoesDefinitivasTest").iniciarTeste(opDefinitivas, "OD2");
    }

}
