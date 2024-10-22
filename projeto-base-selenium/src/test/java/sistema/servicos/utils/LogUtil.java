package sistema.servicos.utils;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class LogUtil {

    private static final Logger logger = LogManager.getLogger(LogUtil.class);

    public static void info(String menssagem) {
        logger.info(menssagem);
    }

    public static void debug(String menssagem) {
        logger.debug(menssagem);
    }

    public static void warn(String menssagem) {
        logger.warn(menssagem);
    }

    public static void error(String menssagem) {
        logger.error(menssagem);
    }

    public static void fatal(String menssagem) {
        logger.fatal(menssagem);
    }

}