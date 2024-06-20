package sistema.amplis.transacoes.cadastropessoas.pessoa.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastroTestCase;

import sistema.amplis.transacoes.cadastropessoas.pessoa.pagina.PaginaPessoa;


public class PessoaUtils extends UtilitarioCadastroTestCase<Pessoa> {

    public PessoaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    private PaginaPessoa pagina = new PaginaPessoa();

    @Override
    protected void preencheDados(Pessoa dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Pessoa.class);
        pagina.preenche(pagina.codigo, dados.codigo());
        pagina.selecionaUm(pagina.tipoDaPessoa, dados.tipoDaPessoa());
        pagina.preenche(pagina.razaoSocial, dados.razaoSocial());
        pagina.preenche(pagina.nomeFantasia, dados.nomeFantasia());
        pagina.preenche(pagina.cnpj, dados.cnpj());
        pagina.selecionaUm(pagina.localidade, dados.localidade());
        pagina.selecionaUm(pagina.setorDeAtividade, dados.setorDeAtividade());
        pagina.selecionaUm(pagina.status, dados.status());
    }

    @Override
    public PessoaUtils executar(Pessoa dados, int posicao) {
        acessa();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return null;
    }

    @Override
    protected void consulta(Pessoa dados, int posicao) {

    }

    @Override
    protected PessoaUtils atualizar(Pessoa dados, int posicao) {
        return this;
    }

    @Override
    protected void excluir(Pessoa dados, int posicao) {

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
