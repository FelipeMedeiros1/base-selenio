package SISTEMA.transacoes.cadastro_pessoas.pessoa;

import WEBDRIVER.base.baseTest.BaseTest;
import org.junit.Test;

public class PessoaTest extends BaseTest {
    private Pessoa pessoa;

    @Test
    public void testIncluirPessoa(){
        new PessoaUtils("PessoaTest").incluir(pessoa,"PS1");
    }
}
