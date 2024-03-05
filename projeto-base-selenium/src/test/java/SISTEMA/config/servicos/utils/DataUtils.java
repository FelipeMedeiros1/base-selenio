package SISTEMA.config.servicos.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataUtils {

    public static Date obterData(int dias){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,dias);
        return calendar.getTime();
    }
    public static String obterDataFormatada(Date data){
        DateFormat format = new SimpleDateFormat("dd/MM/YYYY");
        return format.format(data);
    }

    public static String dataFutura(int dias){
       Date dataFutura =  obterData(dias);
       String resultado = obterDataFormatada(dataFutura);

        return resultado;
    }

}
