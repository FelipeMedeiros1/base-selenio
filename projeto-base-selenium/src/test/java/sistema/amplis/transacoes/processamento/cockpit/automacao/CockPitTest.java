package sistema.amplis.transacoes.processamento.cockpit.automacao;

import sistema.servicos.base.BaseTeste;
import org.junit.Test;

public class CockPitTest extends BaseTeste {
    private CockPit cockPit;
    private String json ="transacoes/processamento/cockpit/automacao/CockPit.json";
    @Test
    public void testCockPit(){
       new CockPitUtils(json).executar(cockPit,1);
    }

}
