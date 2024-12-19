package sistema.transacoes.rendafixa.operacoes_definitivas.automacao;


import servico.leitorDeArquivo.config_json.LeitorJson;

import servico.utils.UtilitarioCadastro;

import sistema.transacoes.rendafixa.operacoes_definitivas.pagina.PaginaOperacoesDefinitivas;

public class OperacoesDefinitivasFixUtils extends UtilitarioCadastro<OperacoesDefinitivas> {
    private final PaginaOperacoesDefinitivas pagina = new PaginaOperacoesDefinitivas();
    private String caminho;
    private String transacao;

    public OperacoesDefinitivasFixUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    public OperacoesDefinitivasFixUtils() {
    }

    @Override
    public void preencheDados(OperacoesDefinitivas dados, int posicao) {
        dados = LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, OperacoesDefinitivas.class);

        selecionaAba(pagina.dadosDaMovimentacao().dadosDaMovimentacao);
        selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDomovimento());
        preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        preenche(pagina.dadosDaMovimentacao().dataDaCompra, dados.dataDaCompra());
        preencheDuplicado(pagina.dadosDaMovimentacao().carteira, dados.carteira()).esperaPor(1000);
        selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo()).esperaPor(1000);
        selecionaUm(pagina.dadosDaMovimentacao().emissao, dados.emissao()).esperaPor(1000);
        if (dados.modalidadeDomovimento().equalsIgnoreCase("Venda a Vista Coberta") || dados.modalidadeDomovimento().equalsIgnoreCase("Retirada a Vista Coberta")) {
            preencheAutoComplete(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        }
        selecionaUm(pagina.dadosDaMovimentacao().ativaPassiva, dados.ativaPassiva());
        selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        selecionaUm(pagina.dadosDaMovimentacao().condicoesDeNegociacao, dados.condicoesDeNegociacao());
        preenche(pagina.dadosDaMovimentacao().pu, dados.pu());
        preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        clicar(pagina.dadosDaMovimentacao().calcular);
        preenche(pagina.dadosDaMovimentacao().financeiro, dados.financeiro());
        selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());

    }

    public void preencheDadosOperacoesDefinitivas(OperacoesDefinitivas dados, int posicao) {
        dados = LeitorJson.carregarDados(obterCaminhoDados(), posicao, OperacoesDefinitivas.class);

        selecionaAba(pagina.dadosDaMovimentacao().dadosDaMovimentacao);
        selecionaUm(pagina.dadosDaMovimentacao().modalidadeDoMovimento, dados.modalidadeDomovimento());
        preenche(pagina.dadosDaMovimentacao().dataDoMovimento, dados.dataDoMovimento());
        preenche(pagina.dadosDaMovimentacao().dataDaCompra, dados.dataDaCompra());
        preencheDuplicado(pagina.dadosDaMovimentacao().carteira, dados.carteira()).esperaPor(1000);
        selecionaUm(pagina.dadosDaMovimentacao().titulo, dados.titulo()).esperaPor(1000);
        selecionaUm(pagina.dadosDaMovimentacao().emissao, dados.emissao()).esperaPor(1000);
        if (dados.modalidadeDomovimento().equalsIgnoreCase("Venda a Vista Coberta") || dados.modalidadeDomovimento().equalsIgnoreCase("Retirada a Vista Coberta")) {
            preencheAutoComplete(pagina.dadosDaMovimentacao().estoque, dados.estoque());
        }
        selecionaUm(pagina.dadosDaMovimentacao().ativaPassiva, dados.ativaPassiva());
        selecionaUm(pagina.dadosDaMovimentacao().categoria, dados.categoria());
        selecionaUm(pagina.dadosDaMovimentacao().riscoBeneficio, dados.riscoBeneficio());
        selecionaUm(pagina.dadosDaMovimentacao().condicoesDeNegociacao, dados.condicoesDeNegociacao());
        preenche(pagina.dadosDaMovimentacao().pu, dados.pu());
        preenche(pagina.dadosDaMovimentacao().quantidade, dados.quantidade());
        clicar(pagina.dadosDaMovimentacao().calcular);
        preenche(pagina.dadosDaMovimentacao().financeiro, dados.financeiro());
        selecionaUm(pagina.dadosDaMovimentacao().rendimento, dados.rendimento());
        selecionaUm(pagina.dadosDaMovimentacao().eventoEmAtraso, dados.eventoEmAtraso());

    }


    @Override
    public void consultar(OperacoesDefinitivas dados, int posicao) {
        dados = LeitorJson.carregarDados(obterCaminhoArquivo(), posicao, OperacoesDefinitivas.class);
        preencheFiltroPesquisa("Carteira", dados.carteira());
        confirmaConsulta();
    }

    private String obterCaminhoDados() {
        return caminho;
    }

    protected String obterCaminhoJson(String valor) {
        return this.caminho = valor;
    }

    protected String transacao(String valor) {
        return this.transacao = valor;
    }

    @Override
    protected String transacao() {
        return "Transações > Renda Fixa > Movimentação > Operações Definitivas";
    }


}
