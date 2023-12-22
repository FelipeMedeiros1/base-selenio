package API.transacoes.renda_fixa.operacoes_termo;

import API.componente.Aba;
import API.componente.Click;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface DadosDeMovimentacaoAba extends Aba {
     SelecionaUm modalidadeDoMovimento(String valor);

     EntradaSimples dataDoMovimento(String valor);

     EntradaSimples dataDaCompra(String valor);

     EntradaSimples dataDoVencimentoDoTermo(String valor);

     EntradaSimples carteira(String valor);

     SelecionaUm titulo(String valor);

     SelecionaUm emissao(String valor);

     SelecionaUm subsegmentoPrevic(String valor);

     EntradaSimples estoque(String valor);

     SelecionaUm nivelDeRisco(String valor);

     SelecionaUm ativaPassiva(String valor);

     SelecionaUm categoria(String valor);

     SelecionaUm riscoBeneficio(String valor);

     SelecionaUm condicaoDeNegociacao(String valor);

     EntradaSimples taxaDeNegociacao(String valor);

     EntradaSimples pu(String valor);

     EntradaSimples quantidade(String valor);

     Click calcular();

     SelecionaUm rendimento(String valor);

     EntradaSimples irDaOperacao(String valor);

     EntradaSimples iofDaOperacao(String valor);

     SelecionaUm eventoEmAtraso(String valor);
}
