package sistema.amplis.transacoes.cadastropessoas.fundos.automacao;


import sistema.amplis.transacoes.cadastropessoas.fundos.pagina.PaginaCadastroFundos;
import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;

import sistema.servicos.utils.UtilitarioCadastro;



public class CadastroFundosUtils extends UtilitarioCadastro<CadastroFundos> {

    public CadastroFundosUtils(String caminhoArquivo) {
        super(caminhoArquivo);

    }

    private PaginaCadastroFundos pagina = new PaginaCadastroFundos();

    @Override
    public void preencheDados(CadastroFundos dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroFundos.class);
        preencheAutoComplete(pagina.carteira, dados.carteira());
        selecionaUm(pagina.formaDeCondominio, dados.formaDeCondominio());
        selecionaUm(pagina.tipoDeFundos, dados.tipoDeFundos());

    }

    @Override
    public CadastroFundosUtils incluir(CadastroFundos dados, int posicao) {
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void consultar(CadastroFundos dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroFundos.class);
        acessaPagina();
        // todo
        confirmaConsulta();
    }

    @Override
    public CadastroFundosUtils atualizar(CadastroFundos dados, int posicao) {
        consultar(dados, posicao);
        alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void excluir(CadastroFundos dados, int posicao) {
        consultar(dados, posicao);
        excluir();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();

    }


}
