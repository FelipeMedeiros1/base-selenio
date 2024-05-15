package sistema.servicos.utils;

import lombok.Getter;


public abstract class UtilitarioCadastroTestCase<M, P>{
    @Getter
    private final String nomeDaPlanilha;
    public UtilitarioCadastroTestCase(String caminhoArquivo) {
        this.nomeDaPlanilha = caminhoArquivo;
    }
    protected abstract void preencheDados(P page, M modeloDeCadastro, String chavePrimaria);
    protected abstract UtilitarioCadastroTestCase<M,P> executarTeste(M modeloDeCadastro, String chavePrimaria);
}
