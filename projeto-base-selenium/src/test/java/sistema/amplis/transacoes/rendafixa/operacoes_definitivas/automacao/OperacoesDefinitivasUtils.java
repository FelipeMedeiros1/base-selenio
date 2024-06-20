package sistema.amplis.transacoes.rendafixa.operacoes_definitivas.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.leitorDeArquivo.config_xls.LeitorXls;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import sistema.amplis.transacoes.rendafixa.operacoes_definitivas.pagina.PaginaOperacoesDefinitivas;

public class OperacoesDefinitivasUtils extends UtilitarioCadastroTestCase<OperacoesDefinitivas> {
    private PaginaOperacoesDefinitivas pagina = new PaginaOperacoesDefinitivas();

    public OperacoesDefinitivasUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(OperacoesDefinitivas dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, OperacoesDefinitivas.class);

        pagina.selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDomovimento());
        pagina.preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        if (!dados.dataDaCompra().equals("")) {
            pagina.preenche(pagina.dadosDaMovimentacao().dataDaCompra, dados.dataDaCompra());
        }
        pagina.preencheAutoComplete(pagina.dadosDaMovimentacao().carteira, dados.carteira()).esperaPor(2000);
        pagina.selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo()).esperaPor(2000);
        pagina.selecionaUm(pagina.dadosDaMovimentacao().emissao, dados.emissao()).esperaPor(2000);
        if (dados.estoque().equalsIgnoreCase("Venda config.propriedades Vista Coberta") || dados.estoque().equalsIgnoreCase("Retirada config.propriedades Vista Coberta")) {
            pagina.selecionaUm(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        }
        pagina.selecionaUm(pagina.dadosDaMovimentacao().ativaPassiva, dados.ativaPassiva());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        if (!dados.condicoesDeNegociacao().equalsIgnoreCase("")) {
            pagina.selecionaUm(pagina.dadosDaMovimentacao().condicoesDeNegociacao, dados.condicoesDeNegociacao());
        }
        pagina.preenche(pagina.dadosDaMovimentacao().pu, dados.pu()).esperaPor(1000);
        pagina.preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        pagina.clicar(pagina.dadosDaMovimentacao().calcular);
        pagina.preenche(pagina.dadosDaMovimentacao().financeiro, dados.financeiro());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        pagina.selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());

    }

    @Override
    public OperacoesDefinitivasUtils executar(OperacoesDefinitivas dados, int posicao) {
        pagina.acessa();
        preencheDados(dados, posicao);
        pagina.confirmaOperacao();
        return this;
    }

    @Override
    protected void consulta(OperacoesDefinitivas dados, int posicao) {

    }

    @Override
    protected OperacoesDefinitivasUtils atualizar(OperacoesDefinitivas dados, int posicao) {
return this;
    }

    @Override
    protected void excluir(OperacoesDefinitivas dados, int posicao) {

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
