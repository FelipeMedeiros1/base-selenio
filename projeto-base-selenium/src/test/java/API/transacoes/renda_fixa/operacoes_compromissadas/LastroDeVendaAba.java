package API.transacoes.renda_fixa.operacoes_compromissadas;

import API.componente.Aba;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface LastroDeVendaAba extends Aba {
    SelecionaUm tituloSelicPu550Titulo();

    SelecionaUm emissao();

    EntradaSimples codigoDaOperacao();

    EntradaSimples dataDeEmissao();

    EntradaSimples dataDeVencimento();

    SelecionaUm calcular();

    EntradaSimples financeiroIda();

    EntradaSimples pu550Pu();

    EntradaSimples quantidade();

    EntradaSimples financeiroDeIdaCalculado();

    EntradaSimples isin();

    EntradaSimples codigoSelicCetip();

    EntradaSimples codigoCBLC();
}
