package API.transacoes.renda_fixa.operacoes_compromissadas;

import API.componente.Aba;
import API.componente.Click;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface DadosDaMovimentacaoAba extends Aba {
    SelecionaUm modalidadeDoMovimento(String valor);

    EntradaSimples dataDoMovimento(String valor);

    EntradaSimples dataDaOperacaoOriginal(String valor);
    EntradaSimples dataDeVencimento(String valor);

    EntradaSimples carteira(String valor);

    SelecionaUm titulo(String valor);

    SelecionaUm estoque(String valor);

    SelecionaUm moeda(String valor);

    SelecionaUm categoria(String valor);

    SelecionaUm riscoBeneficio(String valor);

    SelecionaUm condicoesDeNegociacao(String valor);

    EntradaSimples serie(String valor);

    EntradaSimples porcentagemDaSerie(String valor);

    EntradaSimples puInicio(String valor);
    EntradaSimples quantidade(String valor);
    EntradaSimples financeiroDeIda(String valor);
    Click calcular();

    SelecionaUm rendimento(String valor);

    SelecionaUm eventoEmAtraso(String valor);
    SelecionaUm livreMovimentacao(String valor);
}
