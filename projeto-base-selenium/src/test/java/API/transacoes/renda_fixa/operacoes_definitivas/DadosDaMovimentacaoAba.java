package API.transacoes.renda_fixa.operacoes_definitivas;

import API.componente.Aba;
import API.componente.Click;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface DadosDaMovimentacaoAba extends Aba {
    SelecionaUm modalidadeDoMovimento(String valor);

    EntradaSimples dataDoMovimento(String valor);

    EntradaSimples dataDaCompra(String valor);

    EntradaSimples carteira(String valor);

    SelecionaUm titulo(String valor);

    SelecionaUm emissao(String valor);

    SelecionaUm estoque(String valor);

    SelecionaUm ativaPassiva(String valor);

    SelecionaUm categoria(String valor);

    SelecionaUm riscoBeneficio(String valor);

    SelecionaUm condicoesDeNegociacao(String valor);

    EntradaSimples pu(String valor);

    EntradaSimples quantidade(String valor);

    EntradaSimples financeiro(String valor);

    Click calcular();

    SelecionaUm rendimento(String valor);

    SelecionaUm eventoEmAtraso(String valor);
}
