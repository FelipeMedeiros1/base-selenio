package SISTEMA.suitetestcase;

import API.transacoes.fundos.movimentacao.Movimentacao;
import SISTEMA.transacoes.cadastro_basico.moedas.MoedasTest;
import SISTEMA.transacoes.processamento.bloqueio_liberacao.BloqueioELiberacaoTest;
import SISTEMA.transacoes.processamento.cockpit.CockPitTest;
import SISTEMA.transacoes.processamento.processamento.ProcessamentoTest;
import SISTEMA.relatorios.patrimonio.carteira_diaria.CarteiraDiariaTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        ProcessamentoTest.class,
        CockPitTest.class,
        BloqueioELiberacaoTest.class,
        CarteiraDiariaTest.class,
        MoedasTest.class,
        Movimentacao.class

})

public class SuiteTest {
}
