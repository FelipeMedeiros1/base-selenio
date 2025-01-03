package sistema.transacoes.rendafixa.operacoes_definitivas.automacao;

import base.BaseTeste;
import org.junit.Test;

public class OperacoesDefinitivasTest extends BaseTeste {

    private final String json = "sistema/transacoes/rendafixa/operacoes_definitivas/recursos/OperacoesDefinitivas.json";
    private OperacoesDefinitivas opDefinitivas;


    @Test
    public void incluirOperacoesDefinitivas() {
       new OperacoesDefinitivasFixUtils(json).incluir(opDefinitivas, 1);
    }

}
