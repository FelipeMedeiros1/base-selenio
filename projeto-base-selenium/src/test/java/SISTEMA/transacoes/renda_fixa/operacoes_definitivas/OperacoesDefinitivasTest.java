package SISTEMA.transacoes.renda_fixa.operacoes_definitivas;

import WEBDRIVER.base.BaseTest;
import org.junit.Test;

public class OperacoesDefinitivasTest extends BaseTest {
    private OperacoesDefinitivas opDefinitivas;
    @Test
    public void incluirOperacoesDefinitivas(){
        new OperacoesDefinitivasUtils("OperacoesDefinitivasTest").executarTeste(opDefinitivas, "OD2");
    }

}
