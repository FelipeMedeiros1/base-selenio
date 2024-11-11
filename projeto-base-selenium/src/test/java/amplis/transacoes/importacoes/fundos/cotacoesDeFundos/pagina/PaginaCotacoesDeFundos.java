package amplis.transacoes.importacoes.fundos.cotacoesDeFundos.pagina;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import webdriver.base.BasePagina;

public class PaginaCotacoesDeFundos extends BasePagina {
	@FindBy(id = "mainForm:j_id_1z:16:j_id_2w:7:j_id_2z:1:j_id_36")
	public WebElement cotacoesFundos;

	@FindBy(id = "mainForm:calendarDateBegin:campoInputDate")
	public WebElement dataInicial;

	@FindBy(id = "mainForm:calendarDateEnd:campoInputDate")
	public WebElement dataFinal;
	
	@FindBy(className = "rf-fu-inp")
	public WebElement nomeDoArquivo;
	
	@FindBy(id = "mainForm:modalidadeImportacaoOutputText_dropdown:campo")
	public WebElement tipoImportacao;
	
	@FindBy(id = "mainForm:tipoArquivoOutputText_dropdown:campo")
	public WebElement layoutImportacao;

}
