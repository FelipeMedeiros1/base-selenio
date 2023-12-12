package API.transacoes.renda_fixa;

import WEBDRIVER.config.menu.painel_acoes.Acessa;
import org.openqa.selenium.WebElement;

public interface OperacoesDefinitivas {
    public void modalidadeDoMovimento(String valor);

    public void dataDoMovimento(String valor);

    public void dataDaCompra(String valor);

    public void carteira(String valor);

    public void titulo(String valor);

    public void emissao(String valor);

    public void estoque(String valor);

    public void ativaPassiva(String valor);

    public void categoria(String valor);

    public void riscoBeneficio(String valor);

    public void condicoesDeNegociacao(String valor);

    public void pu(String valor);

    public void quantidade(String valor);

    public void rendimento(String valor);

    public void eventoEmAtraso(String valor);
}
