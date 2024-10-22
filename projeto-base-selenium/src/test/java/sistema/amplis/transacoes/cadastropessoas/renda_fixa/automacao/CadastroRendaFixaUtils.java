package sistema.amplis.transacoes.cadastropessoas.renda_fixa.automacao;

import sistema.amplis.transacoes.cadastropessoas.pessoa.automacao.Pessoa;
import sistema.amplis.transacoes.cadastropessoas.renda_fixa.pagina.PaginaCadastroRendaFixa;
import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastro;

public class CadastroRendaFixaUtils extends UtilitarioCadastro<CadastroRendaFixa> {
    public CadastroRendaFixaUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaCadastroRendaFixa pagina = new PaginaCadastroRendaFixa();

    @Override
    public void preencheDados(CadastroRendaFixa dados, int posicao) {
        LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroRendaFixa.class);
        preencheAutoComplete(pagina.carteira, dados.carteira());

        selecionaAba(pagina.negociacao().negociacao);
        selecionaUm(pagina.negociacao().mtm,dados.mtm());
        confirmaOperacao();

    }

    @Override
    public CadastroRendaFixaUtils incluir(CadastroRendaFixa dados, int posicao) {
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void consultar(CadastroRendaFixa dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroRendaFixa.class);
        pagina.acessa();
        //todo
        confirmaConsulta();
    }

    @Override
    public CadastroRendaFixaUtils atualizar(CadastroRendaFixa dados, int posicao) {
        consultar(dados, posicao);
        alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void excluir(CadastroRendaFixa dados, int posicao) {
        consultar(dados, posicao);
        excluir();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();

    }

}
