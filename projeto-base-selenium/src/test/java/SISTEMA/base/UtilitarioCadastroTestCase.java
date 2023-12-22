package SISTEMA.base;

import lombok.Getter;


public abstract class UtilitarioCadastroTestCase<T, P>{
    @Getter
    private final String nomeDaPlanilha;
    public UtilitarioCadastroTestCase(String nomeDaPlanilha) {
        this.nomeDaPlanilha = nomeDaPlanilha;
    }
    protected abstract void preencheDados(P page, T modeloDeCadastro, String chavePrimaria);
    public abstract UtilitarioCadastroTestCase<T,P> iniciarTeste(T modeloDeCadastro, String chavePrimaria);
}
