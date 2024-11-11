package webdriver.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static webdriver.fabrica.FabricaDeDriver.getDriver;

public class ImportarArquivo {
    /**
     * Importa um arquivo CSV para a aplicação web.
     *
     * @param nomeArquivo O nome do arquivo a ser importado.
     */
    public void importar(String nomeArquivo) {
        String caminhoArquivo = searchFileInProjectDirectory(nomeArquivo);
        preenche(encontrarArquivo(caminhoArquivo));
        clicarEnviar();

        try {
            new FluentWait<>(getDriver()).withTimeout(java.time.Duration.ofSeconds(10))
                    .pollingEvery(java.time.Duration.ofSeconds(1))
                    .ignoring(Exception.class)
                    .until(ExpectedConditions.refreshed(
                            ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                                    "//span[@class='rf-fu-itm-st' and text()='Concluído']"))));
            ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
                    "//span[@class='rf-fu-itm-st' and text()='Concluído']"));
        } catch (Exception e) {
            throw new RuntimeException(
                    "Erro ao importar o arquivo: " + encontrarArquivo(nomeArquivo) + " - " + e.getMessage());
        }

    }

    /**
     * Localiza um arquivo com o nome fornecido na pasta do projeto.
     *
     * @param nomeArquivo O nome do arquivo a ser encontrado.
     * @return O caminho completo do arquivo encontrado.
     * @throws RuntimeException Caso o arquivo não seja encontrado.
     */
    private String encontrarArquivo(String nomeArquivo) {
//        File workingDirectory;
//        workingDirectory = new File(System.getProperty("user.dir"));
//        File foundFile = searchFileInDirectory(workingDirectory, nomeArquivo);
//
//        if (foundFile == null) {
//            throw new RuntimeException("Arquivo " + nomeArquivo + " não encontrado");
//        }
//        return foundFile.getAbsolutePath();



        // Obtém o caminho absoluto do diretório raiz do projeto
        String caminhoRaiz = System.getProperty("user.dir");

        // Cria um objeto Path para o caminho do arquivo
        Path rootPath = Paths.get(caminhoRaiz, "src", "test", "java");

        try {
            return Files.walk(rootPath)
                    .filter(Files::isRegularFile)
                    .filter(path -> path.getFileName().toString().equals(nomeArquivo))
                    .map(Path::toAbsolutePath)
                    .map(Path::toString)
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Arquivo não encontrado: " + nomeArquivo));
        } catch (Exception e) {
            throw new RuntimeException("Arquivo não encontrado: " + e.getMessage(), e);
        }
    }

    /**
     * Preenche todos os campos de entrada com o caminho do arquivo fornecido, pois algumas telas
     * de importação tem mais de um input com o mesmo locator, e nenhum tem a propriedade
     * isDisplayed(), mesmo um deles estando visível.
     *
     * @param caminhoArquivo O caminho completo do arquivo a ser inserido nos campos de entrada.
     */
    private void preenche(String caminhoArquivo) {
        WebElement[] elementos = getDriver()
                .findElements(By.className("rf-fu-inp"))
                .toArray(new WebElement[0]);

        for (WebElement elemento : elementos)
            try {
                new CampoTexto().preenche(elemento, caminhoArquivo);
            } catch (Exception e) {
                throw new RuntimeException(
                        "ERRO ao importar o arquivo [" + caminhoArquivo + "] - "
                                + e.getMessage());
            }
    }

    private File searchFileInDirectory(File directory, final String fileName) {
        if (!directory.isDirectory())
            return null;

        // Busca o arquivo no diretório atual
        File[] files = directory.listFiles((dir, name) -> name.equals(fileName));

        // Assumindo que há apenas um arquivo com esse nome
        if (files != null && files.length > 0)
            return files[0];

        // Busca recursivamente em subdiretórios
        File[] subDirs = directory.listFiles(File::isDirectory);
        if (subDirs != null) {
            for (File subDir : subDirs) {
                File result = searchFileInDirectory(subDir, fileName);
                if (result != null)
                    return result;
            }
        }

        return null;
    }

    /**
     * Clica em todos os botões de envio disponíveis na página, pois algumas telas
     * de importação tem mais de um botão com o mesmo locator, e nenhum tem a propriedade
     * isDisplayed(), mesmo um deles estando visível.
     */
    private void clicarEnviar() {
        WebElement[] botoesEnviar = getDriver()
                .findElements(By.className("rf-fu-btn-cnt-upl"))
                .toArray(new WebElement[0]);

        for (WebElement btnEnviar : botoesEnviar)
            try {
                new Botao().clicar(btnEnviar);
            } catch (Exception e) {
            }

        new Espera().esperaAjaxTerminar();
    }

    protected String searchFileInProjectDirectory(final String fileName) {
        File workingDirectory;
        workingDirectory = new File(System.getProperty("user.dir"));
        File foundFile = searchFileInDirectory(workingDirectory, fileName);

        if (foundFile == null)
            throw new RuntimeException("Arquivo " + fileName + " não encontrado");
        return foundFile.getAbsolutePath();
    }

}
