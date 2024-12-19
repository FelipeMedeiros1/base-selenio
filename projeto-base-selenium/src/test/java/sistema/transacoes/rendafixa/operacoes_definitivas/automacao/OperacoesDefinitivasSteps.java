package sistema.transacoes.rendafixa.operacoes_definitivas.automacao;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.E;
import io.cucumber.java.it.Quando;

import io.cucumber.java.pt.Então;
import sistema.login.PaginaLogin;
import webdriver.componentes.PainelMensagem;


public class OperacoesDefinitivasSteps {

    private final OperacoesDefinitivasFixUtils fixUtils = new OperacoesDefinitivasFixUtils();
    private OperacoesDefinitivas dadosMovimentacao;

    @Dado("que o usuário esteja logado no sistema")
    public void usuarioLogado() {
        new PaginaLogin().executarLogin();
    }

    @E("que o usuário acesse a página: {string}")
    public void queOUsuárioAcesseAPágina(String pagina) {
        fixUtils.transacao(pagina);
    }

    @E("recebe os dados do Arquivo .json {string}, para realização dos testes")
    public void receberDadosJson(String caminhoArquivo) {
        fixUtils.obterCaminhoJson(caminhoArquivo);
    }

    @Quando("o usuário preenche os campos com os dados para realizar a inclusão da movimentação")
    public void preencherCampos() {
        fixUtils.incluir(dadosMovimentacao, 1);
    }

    @Então("a nova operação deverá ser incluída no sistema devolvendo a mensagem de sucesso")
    public void aNovaOperaçãoDeveráSerIncluídaComSucessoNoSistemaDevolvendoAMensagem() {
        PainelMensagem.validaMensagemInclusao();
    }


}