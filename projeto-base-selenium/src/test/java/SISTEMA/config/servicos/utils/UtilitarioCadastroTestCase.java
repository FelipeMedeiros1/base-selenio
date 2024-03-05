package SISTEMA.config.servicos.utils;

import lombok.Getter;


public abstract class UtilitarioCadastroTestCase<M, P>{
    @Getter
    private final String nomeDaPlanilha;
    public UtilitarioCadastroTestCase(String nomeDaPlanilha) {
        this.nomeDaPlanilha = nomeDaPlanilha;
    }
    protected abstract void preencheDados(P page, M modeloDeCadastro, String chavePrimaria);
    protected abstract UtilitarioCadastroTestCase<M,P> executarTeste(M modeloDeCadastro, String chavePrimaria);
}
