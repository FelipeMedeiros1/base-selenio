package sistema.dominio.transacoes.renda_fixa.operacoes_definitivas;

import webdriver.base.BaseTest;
import org.junit.Test;

public class OperacoesDefinitivasTest extends BaseTest {
    private OperacoesDefinitivas opDefinitivas;
    @Test
    public void incluirOperacoesDefinitivas(){
        new OperacoesDefinitivasUtils("OperacoesDefinitivasTest").executarTeste(opDefinitivas, "OD2");
    }

}
