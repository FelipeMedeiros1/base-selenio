package SISTEMA.config.servicos.leitorplanilha;

import lombok.Data;
import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

@Data
public class ExcelReader<T> {

    private Map<String, T> mapaDeDados = new HashMap<>();
    private String caminhoDaPlanilha;
    private String chavePrimaria;


    public ExcelReader(String caminhoPlanilha, String chavePrimaria) {
        this.caminhoDaPlanilha = caminhoPlanilha;
        this.chavePrimaria = chavePrimaria;
    }

    public void lerDados(Class<T> dataClass) {
        try (Workbook workbook = WorkbookFactory.create(new FileInputStream(caminhoDaPlanilha))) {
            Sheet planilha = workbook.getSheetAt(0); // Acessa Leitor primeira planilha

            Row cabecalho = planilha.getRow(0);
            int numColumns = cabecalho.getLastCellNum();

            for (int linha = 1; linha <= planilha.getLastRowNum(); linha++) {
                Row dadosDaLinha = planilha.getRow(linha);

                T dataInstance = dataClass.getDeclaredConstructor().newInstance();
                String chavePrimaria = null;

                for (int coluna = 0; coluna < numColumns; coluna++) {
                    Cell celula = dadosDaLinha.getCell(coluna);
                    String nomeCampo = cabecalho.getCell(coluna).getStringCellValue();
                    if (nomeCampo.equals(this.chavePrimaria)) {
                        chavePrimaria = celula.getStringCellValue();
                    }
                    setValorCampo(dataInstance, nomeCampo, celula.getStringCellValue());
                }

                if (chavePrimaria != null) {
                    mapaDeDados.put(chavePrimaria, dataInstance);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private T setValorCampo(Object object, String nomeCampo, String valor) {
        try {
            Class<?> clazz = object.getClass();
            java.lang.reflect.Field campo = clazz.getDeclaredField(nomeCampo);
            campo.setAccessible(true);

            if (campo.getType().isArray()) {
                String[] values = valor.split(",");
                campo.set(object, values);
            } else {
                campo.set(object, valor);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return mapaDeDados.get(chavePrimaria);
    }

    public T getDataByPrimaryKey(String primaryKeyValue) {
        return mapaDeDados.get(primaryKeyValue);
    }

//    public static void main(String[] args) {
//        ExcelReader<ProcessamentoDados> excelReader = new ExcelReader<>("src/test/java/SISTEMA/processamento/processamento/OperacoesATermoTest.xlsx", "pkProcessamento");
//        excelReader.readData(ProcessamentoDados.class);
//
//        ProcessamentoDados processamento = excelReader.getDataByPrimaryKey("chave_primaria_aqui");
//        System.out.println(processamento);
//    }
}
