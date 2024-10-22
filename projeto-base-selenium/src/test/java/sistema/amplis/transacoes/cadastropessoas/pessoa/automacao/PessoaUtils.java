package sistema.amplis.transacoes.cadastropessoas.pessoa.automacao;


import sistema.servicos.leitorDeArquivo.config_json.LeitorJson;
import sistema.servicos.utils.UtilitarioCadastro;

import sistema.amplis.transacoes.cadastropessoas.pessoa.pagina.PaginaPessoa;


public class PessoaUtils extends UtilitarioCadastro<Pessoa> {

    public PessoaUtils(String nomeDaPlanilha) {
        super(nomeDaPlanilha);
    }

    private PaginaPessoa pagina = new PaginaPessoa();

    @Override
    public void preencheDados(Pessoa dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Pessoa.class);
        preenche(pagina.codigo, dados.codigo());
        selecionaUm(pagina.tipoDaPessoa, dados.tipoDaPessoa());
        preenche(pagina.razaoSocial, dados.razaoSocial());
        preenche(pagina.nomeFantasia, dados.nomeFantasia());
        preenche(pagina.cnpj, dados.cnpj());
        selecionaUm(pagina.localidade, dados.localidade());
        selecionaUm(pagina.setorDeAtividade, dados.setorDeAtividade());
        selecionaUm(pagina.status, dados.status());
    }

    @Override
    public PessoaUtils incluir(Pessoa dados, int posicao) {
        acessaPagina();
        inserir();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void consultar(Pessoa dados, int posicao) {
        dados = LeitorJson.carregarDados(getCaminhoArquivo(), posicao, Pessoa.class);
        acessaPagina();
        //todo
        confirmaConsulta();
    }

    @Override
    public void acessaPagina() {
        pagina.acessa();
        inserir();
    }


    @Override
    public PessoaUtils atualizar(Pessoa dados, int posicao) {
        consultar(dados, posicao);
        alterar();
        preencheDados(dados, posicao);
        confirmaOperacao();
        return this;
    }

    @Override
    public void excluir(Pessoa dados, int posicao) {
        consultar(dados, posicao);
        excluir();
    }


}
