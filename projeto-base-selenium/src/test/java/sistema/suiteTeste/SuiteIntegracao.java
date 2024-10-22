package sistema.suiteTeste;


import sistema.amplis.relatorios.patrimonio.carteira_diaria.automacao.CarteiraDiariaTest;
import sistema.amplis.transacoes.cadastrobasico.moedas.automacao.MoedasTest;
import sistema.amplis.transacoes.processamento.bloqueio_liberacao.automacao.BloqueioELiberacaoTest;
import sistema.amplis.transacoes.processamento.cockpit.automacao.CockPitTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import sistema.amplis.transacoes.processamento.processamento.automacao.ProcessamentoTest;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        ProcessamentoTest.class,
        CockPitTest.class,
        BloqueioELiberacaoTest.class,
        CarteiraDiariaTest.class,
        MoedasTest.class

})

public class SuiteIntegracao {
}
