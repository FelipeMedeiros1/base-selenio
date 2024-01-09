package API.transacoes.renda_fixa.operacoes_compromissadas;

import API.componente.Aba;
import API.componente.EntradaSimples;
import API.componente.SelecionaUm;

public interface LastroDeCompraAba extends Aba {
    EntradaSimples tituloSelicPu550Titulo();

    SelecionaUm titulo();

    SelecionaUm emissao();

    EntradaSimples dataDaEmissao();

    EntradaSimples dataDeVencimento();

    SelecionaUm calcular();

    EntradaSimples financeiroIda();

    EntradaSimples pu550Pu();

    EntradaSimples quantidade();

    EntradaSimples financeiroDeIdaCalculado();

    EntradaSimples isin();

    EntradaSimples codigoSelicCetipCompra();

    SelecionaUm esferaDaEmissao();

    SelecionaUm empresaLigada();

    SelecionaUm descricaoBacen();

    EntradaSimples codigoCBLCCompra();

    SelecionaUm localidade();

    SelecionaUm emissorParaPerfilMensal();

}
