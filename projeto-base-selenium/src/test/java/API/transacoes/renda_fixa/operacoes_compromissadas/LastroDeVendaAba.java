package API.transacoes.renda_fixa.operacoes_compromissadas;

import API.componente.Aba;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface LastroDeVendaAba extends Aba {
    SelecionaUm tituloSelicPu550Titulo(String valor);

    SelecionaUm emissao(String valor);

    EntradaSimples codigoDaOperacao(String valor);

    EntradaSimples dataDeEmissao(String valor);

    EntradaSimples dataDeVencimento(String valor);

    SelecionaUm calcular(String valor);

    EntradaSimples financeiroIda(String valor);

    EntradaSimples pu550Pu(String valor);

    EntradaSimples quantidade(String valor);

    EntradaSimples financeiroDeIdaCalculado(String valor);

    EntradaSimples isin(String valor);

    EntradaSimples codigoSelicCetip(String valor);

    EntradaSimples codigoCBLC(String valor);
}
