package amplis.transacoes.cadastropessoas.fundos.automacao;


import amplis.transacoes.cadastropessoas.fundos.pagina.PaginaCadastroFundos;
import servico.leitorDeArquivo.config_json.LeitorJson;

import webdriver.base.navegacao.automacao.MenuNavegacao;
import servico.utils.UtilitarioCadastro;


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
    public void consultar(CadastroFundos dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroFundos.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }



    @Override
    protected String transacao() {
        return null;
    }
}
