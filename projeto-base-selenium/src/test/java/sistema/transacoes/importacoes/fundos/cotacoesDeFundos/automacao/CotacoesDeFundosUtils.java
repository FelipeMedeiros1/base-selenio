package sistema.transacoes.importacoes.fundos.cotacoesDeFundos.automacao;

import utils.leitorDeArquivo.config_json.LeitorJson;
import sistema.transacoes.importacoes.fundos.cotacoesDeFundos.pagina.PaginaCotacoesDeFundos;
import sistema.servico.utils.UtilitarioImportacao;

public class CotacoesDeFundosUtils extends UtilitarioImportacao<CotacoesDeFundos> {
    public CotacoesDeFundosUtils(String caminhoJson) {
        super(caminhoJson);
    }

    private final PaginaCotacoesDeFundos pagina = new PaginaCotacoesDeFundos();

    @Override
    protected void preencheDados(CotacoesDeFundos dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CotacoesDeFundos.class);
        preenche(pagina.dataInicial, dados.dataInicial()).esperaPor(2000);
        preenche(pagina.dataFinal, dados.dataFinal());
        selecionaUm(pagina.tipoImportacao, dados.tipoImportacao());
        selecionaUm(pagina.layoutImportacao, dados.layoutImportacao());
        importarArquivo(dados.nomeDoArquivo());
    }

    protected void preencheDados(String caminhoArquivo, CotacoesDeFundos dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(caminhoArquivo), posicao, CotacoesDeFundos.class);
        preenche(pagina.dataInicial, dados.dataInicial()).esperaPor(2000);
        preenche(pagina.dataFinal, dados.dataFinal());
        selecionaUm(pagina.tipoImportacao, dados.tipoImportacao());
        selecionaUm(pagina.layoutImportacao, dados.layoutImportacao());
        importarArquivo(dados.nomeDoArquivo());
    }

    @Override
    public void acessaPagina() {

    }


    public String getCaminhoArquivo(String valor) {
        return valor;
    }

    @Override
    protected String transacoes() {
        return "Transações > Importações > Fundos > Cotações de Fundos";
    }
}
