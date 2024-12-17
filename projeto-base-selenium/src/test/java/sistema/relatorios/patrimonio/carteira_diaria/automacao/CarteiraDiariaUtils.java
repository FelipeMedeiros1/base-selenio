package sistema.relatorios.patrimonio.carteira_diaria.automacao;

import servico.leitorDeArquivo.config_json.LeitorJson;
import servico.utils.UtilitarioRelatorio;
import sistema.relatorios.patrimonio.carteira_diaria.pagina.PaginaCarteiraDiaria;

public class CarteiraDiariaUtils extends UtilitarioRelatorio<CarteiraDiaria> {

    private final PaginaCarteiraDiaria pagina = new PaginaCarteiraDiaria();

    public CarteiraDiariaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    @Override
    protected void preencheDados(CarteiraDiaria dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CarteiraDiaria.class);

        preenche(pagina.dataInicio, dados.dataInicio());
        preenche(pagina.dataFinal, dados.dataFinal());
        clicar(pagina.deseleciona);
        selecionaPickList(pagina.tipoDePosicao, dados.tipoDePosicao());
        selecionaUm(pagina.tipoDeConsolidacao, dados.tipoDeConsolidacao());
        selecionaUm(pagina.custoMedio, dados.custoMedio());
        selecionaPickList(pagina.carteira, dados.carteira());
        selecionaUm(pagina.tipoDoRelatorio, dados.tipoDoRelatorio());
        selecionaUm(pagina.saida, dados.saida());
    }

    @Override
    public CarteiraDiariaUtils gerarRelatorio(CarteiraDiaria dados, int posicao) {
        acessaPagina();
        preencheDados(dados, posicao);
        confirma();
        return this;
    }


    @Override
    protected String relatorio() {
        return "Relatórios > Patrimônio > Carteira Diária";
    }


}
