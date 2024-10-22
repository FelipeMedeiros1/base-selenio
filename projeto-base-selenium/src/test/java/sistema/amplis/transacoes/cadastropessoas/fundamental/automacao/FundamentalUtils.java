package sistema.amplis.transacoes.cadastropessoas.fundamental.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.LogUtil;
import sistema.servicos.utils.UtilitarioCadastro;

import sistema.amplis.transacoes.cadastropessoas.fundamental.pagina.PaginaFundamental;


import static sistema.servicos.utils.LogUtil.info;

public class FundamentalUtils extends UtilitarioCadastro<Fundamental> {

    private PaginaFundamental pagina = new PaginaFundamental();


    public FundamentalUtils(String caminhoArquivo) {
        super(caminhoArquivo);
        info("Acessando: Transações > Cadastros de Pessoas > Carteiras > Cadastros > Fundamental");
    }

    @Override
    public void preencheDados(Fundamental dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Fundamental.class);
        preencheAutoComplete(pagina.pessoa, dados.pessoa());
        preenche(pagina.codigo, dados.codigo());
        selecionaUm(pagina.localidade, dados.localidade());
        selecionaUm(pagina.status, dados.status());
        selecionaPickList(pagina.grupoDeCarteiras, dados.grupoDeCarteiras());

        selecionaAba(pagina.apropriacao().apropriacaoAgentes);
        preencheAutoComplete(pagina.apropriacao().administrador, dados.administrador());
        preencheAutoComplete(pagina.apropriacao().gestor, dados.gestor());
        preencheAutoComplete(pagina.apropriacao().custodiante, dados.custodiante());
    }

    @Override
    public FundamentalUtils incluir(Fundamental dados, int posicao) {
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void consultar(Fundamental dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Fundamental.class);
        acessaPagina();
        selecionaUm(pagina.consulta().filtroConsulta, "Igual");
        preenche(pagina.consulta().codigoConsulta, dados.codigo());
        confirmaConsulta();
    }

    @Override
    public FundamentalUtils atualizar(Fundamental dados, int posicao) {
        consultar(dados, posicao);
        alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void excluir(Fundamental dados, int posicao) {
        consultar(dados, posicao);
        excluir();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();

    }

}
