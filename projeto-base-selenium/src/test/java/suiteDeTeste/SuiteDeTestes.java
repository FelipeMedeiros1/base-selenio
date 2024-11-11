package suiteDeTeste;


import org.junit.runner.RunWith;
import amplis.transacoes.cadastropessoas.fundamental.automacao.FundamentalTest;

import org.junit.runners.Suite;

import static org.junit.runners.Suite.*;

@RunWith(Suite.class)
@SuiteClasses({
        FundamentalTest.class


})

public class SuiteDeTestes {
}
