package sistema.suitetestcase;

import sistema.dominio.transacoes.cadastro_basico.moedas.MoedasTest;
import sistema.dominio.transacoes.processamento.bloqueio_liberacao.BloqueioELiberacaoTest;
import sistema.dominio.transacoes.processamento.cockpit.CockPitTest;
import sistema.dominio.transacoes.processamento.processamento.ProcessamentoTest;
import sistema.dominio.relatorios.patrimonio.carteira_diaria.CarteiraDiariaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        ProcessamentoTest.class,
        CockPitTest.class,
        BloqueioELiberacaoTest.class,
        CarteiraDiariaTest.class,
        MoedasTest.class

})

public class SuiteTest {
}
