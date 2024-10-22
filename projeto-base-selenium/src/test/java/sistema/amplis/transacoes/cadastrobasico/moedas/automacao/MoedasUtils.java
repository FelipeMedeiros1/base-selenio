package sistema.amplis.transacoes.cadastrobasico.moedas.automacao;

import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.amplis.transacoes.cadastrobasico.moedas.pagina.PaginaMoedas;
import sistema.servicos.utils.UtilitarioCadastro;
import webdriver.componentes.Atalho;


import static sistema.servicos.utils.LogUtil.info;


public class MoedasUtils extends UtilitarioCadastro<Moedas> {

    public MoedasUtils(String caminhoArquivo) {
        super(caminhoArquivo);
        info("Acessando: Transações > Cadastros Básicos > Moedas");
    }

    private PaginaMoedas pagina = new PaginaMoedas();

    @Override
    public void preencheDados(Moedas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Moedas.class);
        preenche(pagina.codigo, dados.codigo());
        preenche(pagina.nome, dados.nome());
        preenche(pagina.simbolo, dados.simbolo());
        selecionaUm(pagina.status, dados.status());

    }

    @Override
    public MoedasUtils incluir(Moedas dados, int posicao) {
        info("Iniciando teste de Cadastro");
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    public void consultar(Moedas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Moedas.class);
        info("Realizando consulta... ");
        acessaPagina();
        selecionaUm(pagina.consulta().filtroConsulta, "Contém");
        preenche(pagina.consulta().codigoConsulta, dados.codigo());
        confirmaConsulta();

    }

//    public boolean consultarChave(Moedas dados, int posicao) {
//        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Moedas.class);
//        info("Realizando consulta... ");
//        acessaConsulta();
//        selecionaUm(pagina.consulta().filtroConsulta, "Igual");
//        preenche(pagina.consulta().codigoConsulta, dados.codigo());
//        confirmaConsulta();
//        return false;
//    }


    @Override
    public MoedasUtils atualizar(Moedas dados, int posicao) {
        info("Iniciando teste de Atualização");
        consultar(dados, posicao);
        alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    public void excluir(Moedas dados, int posicao) {
        info("Iniciando teste de Exclusão");
        consultar(dados, posicao);
        excluir();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();

    }

    public Class<Moedas> getTipoDeDados() {
        return Moedas.class;
    }
}
