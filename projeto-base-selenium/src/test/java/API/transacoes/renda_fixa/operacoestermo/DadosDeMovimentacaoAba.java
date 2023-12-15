package API.transacoes.renda_fixa.operacoestermo;

import API.componente.Aba;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface DadosDeMovimentacaoAba extends Aba {
    public SelecionaUm modalidadeDoMovimento(String valor);

    public EntradaSimples dataDoMovimento(String valor);

    public EntradaSimples dataDaCompra(String valor);

    public EntradaSimples dataDoVencimentoDoTermo(String valor);

    public EntradaSimples carteira(String valor);

    public SelecionaUm titulo(String valor);

    public SelecionaUm emissao(String valor);

    public SelecionaUm subsegmentoPrevic(String valor);

    public EntradaSimples estoque(String valor);

    public SelecionaUm nivelDeRisco(String valor);

    public SelecionaUm ativaPassiva(String valor);

    public SelecionaUm categoria(String valor);

    public SelecionaUm riscoBeneficio(String valor);

    public SelecionaUm condicaoDeNegociacao(String valor);

    public EntradaSimples taxaDeNegociacao(String valor);

    public EntradaSimples pu(String valor);

    public EntradaSimples quantidade(String valor);

    public void calcular();

    public SelecionaUm rendimento(String valor);

    public EntradaSimples irDaOperacao(String valor);

    public EntradaSimples iofDaOperacao(String valor);

    public SelecionaUm eventoEmAtraso(String valor);
}
