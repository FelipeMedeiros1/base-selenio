package sistema.transacoes.processamento.cockpit.automacao;

import servico.base.BaseTeste;
import org.junit.Test;

public class CockPitTest extends BaseTeste {



    private CockPit cockPit;
    private final String json = "amplis/transacoes/processamento/cockpit/automacao/CockPit.json";

    @Test
    public void testVerificarStatusProcessamentoNoCockPit() {

        new CockPitUtils(json).executar(cockPit, 1);
    }

}
