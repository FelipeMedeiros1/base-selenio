package test.java.lojinha.login;

import test.java.lojinha.automacao.Interagivel;
import test.java.utils.leitorDeArquivo.LeitorPropriedade;
import test.java.webdriver.componentes.Evidencia;

import static test.java.webdriver.componentes.Evidencia.capturaTelaInfo;


public class Login extends Interagivel {
    private PaginaLogin pagina = new PaginaLogin();

    public void executarLogin() {
        String login = LeitorPropriedade.getLogin();
        String senha = LeitorPropriedade.getSenha();
        String url = LeitorPropriedade.getUrl();

        if (url == null || login == null || senha == null) {
            throw new RuntimeException("As propriedades do arquivo config.propriedades não foram configuradas corretamente.");
        }
        capturaTelaInfo("Login","Acessando tela de login");
        preenche(pagina.usuario, login);
        preenche(pagina.senha, senha);
    }
}
