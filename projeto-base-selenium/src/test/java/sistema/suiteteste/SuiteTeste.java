package sistema.suiteteste;


import sistema.amplis.transacoes.processamento.bloqueio_liberacao.automacao.BloqueioELiberacaoTest;
import sistema.amplis.transacoes.processamento.cockpit.automacao.CockPitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
//        ProcessamentoTest.class,
        CockPitTest.class,
        BloqueioELiberacaoTest.class,
//        CarteiraDiariaTest.class,
//        MoedasTest.class

})

public class SuiteTeste {
}
