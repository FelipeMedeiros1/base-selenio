package testeGitHub.automacao;

import servico.utils.UtilitarioCadastro;

public class GitHubUtils extends UtilitarioCadastro<GitHub> {

    @Override
    protected void preencheDados(GitHub dados, int posicao) {

    }

    @Override
    public void consultar(GitHub dados, int posicao) {

    }

    @Override
    protected String transacao() {
        return "";
    }
}
