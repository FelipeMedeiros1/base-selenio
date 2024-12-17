package sistema.transacoes.cadastropessoas.fundamental.automacao;



import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioCadastro;
import sistema.transacoes.cadastropessoas.fundamental.pagina.PaginaFundamental;

import static webdriver.componentes.Evidencia.capturaTelaInfo;

public class FundamentalUtils extends UtilitarioCadastro<Fundamental> {
    public FundamentalUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private final PaginaFundamental pagina = new PaginaFundamental();

    @Override
    public void preencheDados(Fundamental dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Fundamental.class);
        preencheAutoComplete(pagina.pessoa, dados.pessoa());
        preenche(pagina.codigo, dados.codigo());
        capturaTelaInfo("preencheDadosInclusao", "Preencheendo dados para inclusão");
        selecionaUm(pagina.localidade, dados.localidade());
        selecionaUm(pagina.status, dados.status());
        selecionaPickList(pagina.grupoDeCarteiras, dados.grupoDeCarteiras());

        selecionaAba(pagina.apropriacao().apropriacaoAgentes);
        preencheAutoComplete(pagina.apropriacao().administrador, dados.administrador());
        preencheAutoComplete(pagina.apropriacao().gestor, dados.gestor());
        preencheAutoComplete(pagina.apropriacao().custodiante, dados.custodiante());
    }

    @Override
    public void consultar(Fundamental dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Fundamental.class);
        preencheFiltroPesquisa("Código", dados.codigo());
        confirmaConsulta();
    }



    @Override
    protected String transacao() {
        return "Transações > Cadastros de Pessoas > Carteiras > Cadastros > Fundamental";
    }

}
