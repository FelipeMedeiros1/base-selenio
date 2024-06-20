package sistema.amplis.transacoes.cadastropessoas.fundamental.automacao;


import sistema.amplis.transacoes.fundos.movimentacao.automacao.Movimentacao;
import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import sistema.amplis.transacoes.cadastropessoas.fundamental.pagina.PaginaFundamental;

public class FundamentalUtils extends UtilitarioCadastroTestCase<Fundamental> {

    private PaginaFundamental pagina = new PaginaFundamental();


    public FundamentalUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    @Override
    protected void preencheDados(Fundamental dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Fundamental.class);
        pagina.preencheAutoComplete(pagina.pessoa, dados.pessoa());
        pagina.preenche(pagina.codigo, dados.codigo());
        pagina.selecionaUm(pagina.localidade, dados.localidade());
        pagina.selecionaVarios(pagina.grupoDeCarteiras, dados.grupoDeCarteiras());
        pagina.selecionaTodos();
        pagina.preencheAutoComplete(pagina.apropriacao().administrador, dados.administrador());
        pagina.preencheAutoComplete(pagina.apropriacao().gestor, dados.gestor());
        pagina.preencheAutoComplete(pagina.apropriacao().custodiante, dados.custodiante());
    }

    @Override
    public FundamentalUtils executar(Fundamental dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    protected void consulta(Fundamental dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Fundamental.class);
        pagina.consulta().acessaConsulta();
        pagina.selecionaUm(pagina.consulta().filtroConsulta, dados.filtroConsulta());
        pagina.preenche(pagina.consulta().codigoConsulta, dados.codigoConsulta());
        pagina.confirma();
        pagina.selecionaNaGrid(0).clicarGrid();
    }

    @Override
    protected FundamentalUtils atualizar(Fundamental dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Fundamental.class);
        consulta(dados, posicao);
        pagina.alterar();
        pagina.preenche(pagina.codigo, dados.codigo());
        confirmaOperacao();
        return this;
    }

    @Override
    protected void excluir(Fundamental dados, int posicao) {
        consulta(dados, posicao);
        pagina.excluir();
    }

    @Override
    public void acessa() {
        pagina.acessa();
    }

    @Override
    public void confirmaOperacao() {
        pagina.confirmaOperacao();
    }
}
