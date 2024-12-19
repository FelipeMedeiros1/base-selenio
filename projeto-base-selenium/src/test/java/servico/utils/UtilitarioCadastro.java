package servico.utils;

import servico.base.Interagivel;
import webdriver.base.navegacao.automacao.NavegacaoSistema;

import static webdriver.componentes.Evidencia.capturaTelaInfo;


public abstract class UtilitarioCadastro<M> extends Interagivel {

    private String caminhoArquivo;

    public UtilitarioCadastro(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public UtilitarioCadastro(){}

    protected abstract void preencheDados(M dados, int posicao);

    public abstract void consultar(M dados, int posicao);

    protected abstract String transacao();

    public UtilitarioCadastro<M> incluir(M dados, int posicao) {
        acessaPagina();
        capturaTelaInfo("capturaTelaMenuTransacoes", "Acessando: " + transacao() + " > Inclusão");
        inserir();
        capturaTelaInfo("capturaTelaTesteInclusao", "Iniciando teste de uma nova Inclusão.");
        preencheDados(dados, posicao);
        capturaTelaInfo("capturaTelaDadosInclusão", "Foram preenchidos os dados para a Inclusão.");
        confirmaOperacao();
        return this;
    }

    public UtilitarioCadastro<M> alterar(M dados, int posicao) {
        acessaPagina();
        capturaTelaInfo("capturaTelaMenuTransacoes", "Acessando: " + transacao() + " > Alteração");
        consultar(dados, posicao);
        capturaTelaInfo("capturaTelaTesteAlteracao", "Iniciando teste de Alteração.");
        alterar();
        preencheDados(dados, posicao);
        capturaTelaInfo("capturaTelaDadosAlteracao", "Foram preenchidos os dados para Alteração.");
        confirmaOperacao();
        return this;
    }

    public void excluir(M dados, int posicao) {
        acessaPagina();
        capturaTelaInfo("capturaTelaMenuTransacoes", "Acessando: " + transacao() + " > Remoção");
        consultar(dados, posicao);
        capturaTelaInfo("capturaTelaTesteExclusao", "Iniciando teste de Exclusão.");
//        excluir();
    }


    protected void acessaPagina() {
        new NavegacaoSistema().navegarPara(transacao());
    }

    public String obterCaminhoArquivo() {
        return caminhoArquivo;
    }
}
