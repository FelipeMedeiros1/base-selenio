package sistema.amplis.transacoes.cadastrobasico.moedas.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.amplis.transacoes.cadastrobasico.moedas.pagina.PaginaMoedasConsulta;
import sistema.amplis.transacoes.cadastrobasico.moedas.pagina.PaginaMoedas;
import sistema.servicos.utils.UtilitarioCadastroTestCase;


public class MoedasUtils extends UtilitarioCadastroTestCase<Moedas> {

    public MoedasUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaMoedas pagina = new PaginaMoedas();

    @Override
    protected void preencheDados(Moedas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Moedas.class);
        pagina.preenche(pagina.codigo, dados.codigo());
        pagina.preenche(pagina.nome, dados.nome());
        pagina.preenche(pagina.simbolo, dados.simbolo());
        pagina.selecionaUm(pagina.status, dados.status());
    }

    @Override
    protected MoedasUtils executar(Moedas dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    protected void consulta(Moedas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Moedas.class);
        pagina.consulta().acessaConsulta();
        pagina.selecionaUm(pagina.consulta().filtroConsulta, dados.filtroConsulta());
        pagina.preenche(pagina.consulta().codigoConsulta, dados.codigoConsulta());
        pagina.confirma();
        pagina.selecionaNaGrid(0).clicarGrid();
    }


    @Override
    protected MoedasUtils atualizar(Moedas dados, int posicao) {
        consulta(dados, posicao);
        pagina.alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    protected void excluir(Moedas dados, int posicao) {
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
