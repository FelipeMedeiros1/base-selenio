package lojinha.automacao;


import utils.leitorDeArquivo.config_json.LeitorJson;

public class LojinhaUtils extends UtilitarioLojinha<Lojinha> {
    private String caminhoDoArquivo;
    private PaginaLojinha pagina = new PaginaLojinha();

    public LojinhaUtils(String caminhoDoArquivo) {
        this.caminhoDoArquivo = caminhoDoArquivo;
    }

    @Override
    protected void preencheDadosProduto(Lojinha dados, int posicao) {
        dados = LeitorJson.carregarDados(caminhoDoArquivo, posicao, Lojinha.class);
        preenche(pagina.nomeDoProduto, dados.nomeDoProduto());
        preenche(pagina.valorDoProduto, dados.valorDoProduto());
        preenche(pagina.coresDoProduto, dados.coresDoProduto());

    }

    @Override
    protected void preencheDadosComponente(Lojinha dados, int posicao) {
        dados = LeitorJson.carregarDados(caminhoDoArquivo, posicao, Lojinha.class);
        preenche(pagina.nomeDoComponente, dados.nomeDoComponente());
        preenche(pagina.quantidadeComponente, dados.quantidadeDoComponente());
    }

    @Override
    protected UtilitarioLojinha editar(Lojinha dados, int posicao) {
        dados = LeitorJson.carregarDados(caminhoDoArquivo, posicao, Lojinha.class);
        editar(dados.nomeDoProduto());
        preencheDadosProduto(dados, posicao);
        return null;
    }


}
