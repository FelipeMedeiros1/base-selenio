package sistema.amplis.relatorios.patrimonio.carteira_diaria.automacao;


import sistema.amplis.relatorios.patrimonio.carteira_diaria.pagina.PaginaCarteiraDiaria;
import sistema.servicos.leitorDeArquivo.ValidadorDeArquivo;
import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioRelatorio;

import static sistema.servicos.leitorDeArquivo.ValidadorDeArquivo.validaCSV;


public class CarteiraDiariaUtils extends UtilitarioRelatorio<CarteiraDiaria> {

    private PaginaCarteiraDiaria pagina = new PaginaCarteiraDiaria();

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
    public void acessaPagina() {
        pagina.acessa();
    }


}
