package suiteDeTeste;


import org.junit.runner.RunWith;


import org.junit.runners.Suite;
import sistema.integrado.taxas.ProcessamentoTest;
import sistema.transacoes.cadastropessoas.fundamental.automacao.FundamentalTest;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        FundamentalTest.class,
        ProcessamentoTest.class


})

public class SuiteDeTestes {
}
