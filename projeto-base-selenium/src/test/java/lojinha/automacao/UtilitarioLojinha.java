package lojinha.automacao;

import lojinha.login.Login;

import static webdriver.componentes.Evidencia.capturaTelaInfo;

public abstract class UtilitarioLojinha<M> extends Interagivel {

    protected abstract void preencheDadosProduto(M dados, int posicao);
    protected abstract void preencheDadosComponente(M dados, int posicao);

    protected UtilitarioLojinha<M> incluir(M dados, int posicao) {
        capturaTelaInfo("capturaTelaInicial", "Acessando tela inicial " );
        adicionarProduto();
        capturaTelaInfo("capturaTelaInclusaoProduto", "Acessando tela de inclusão produto");
        preencheDadosProduto(dados,posicao);
        capturaTelaInfo("capturaTelaDadosProduto", "Foram preenchidos os dados do produto." );
        salvarProduto();
        adicionarComponente();
        capturaTelaInfo("capturaTelaInclusaoComponente", "Acessando tela de inclusão componente");
        preencheDadosComponente(dados,posicao);
        capturaTelaInfo("capturaTelaDadosComponente", "Foram preenchidos os dados do componente." );
        salvarComponente();
        listaDeProdutos();
        capturaTelaInfo("capturaTelaListaDeProdutos", "Acessando tela lista de produtos" );

        return this;
    }

    protected UtilitarioLojinha<M> remover(M dados, int posicao) {
        editar(dados, posicao);
        clicarXpath("delete");
        return this;
    }


    protected abstract UtilitarioLojinha<M> editar(M dados, int posicao);

    protected void executarLogin(){
        new Login().executarLogin();
        entrar();
    }

}
