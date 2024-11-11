package amplis.transacoes.rendafixa.operacoes_definitivas.automacao;

import servico.base.BaseTeste;
import org.junit.Test;

public class OperacoesDefinitivasTest extends BaseTeste {
    private OperacoesDefinitivas opDefinitivas;
    private String json = "amplis/transacoes/rendafixa/operacoes_definitivas/automacao/OperacoesDefinitivas.json";
    @Test
    public void incluirOperacoesDefinitivas(){
        new OperacoesDefinitivasFixUtils(json).incluir(opDefinitivas, 1);
    }

}
