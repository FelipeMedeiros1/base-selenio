package sistema.amplis.transacoes.cadastropessoas.patrimonio.automacao;

import sistema.amplis.transacoes.cadastropessoas.patrimonio.pagina.PaginaCadastroPatrimonio;
import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastro;

public class CadastroPatrimonioUtils extends UtilitarioCadastro<CadastroPatrimonio> {
    public CadastroPatrimonioUtils(String caminhoArquivo) {
        super(caminhoArquivo);
    }

    private PaginaCadastroPatrimonio pagina = new PaginaCadastroPatrimonio();

    @Override
    public void preencheDados(CadastroPatrimonio dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroPatrimonio.class);
        preencheAutoComplete(pagina.carteira, dados.carteira());
        preencheAutoComplete(pagina.valorDaCotaInicial, dados.valorDaCotaInicial());
    }

    @Override
    public CadastroPatrimonioUtils incluir(CadastroPatrimonio dados, int posicao) {
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void consultar(CadastroPatrimonio dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, CadastroPatrimonio.class);
        acessaPagina();
        //todo
        confirmaConsulta();
    }

    @Override
    public CadastroPatrimonioUtils atualizar(CadastroPatrimonio dados, int posicao) {
        consultar(dados, posicao);
        alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void excluir(CadastroPatrimonio dados, int posicao) {
        consultar(dados, posicao);
        excluir();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();

    }


}
