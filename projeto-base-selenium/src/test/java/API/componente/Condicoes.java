package API.componente;
import com.google.common.base.Function;
import org.openqa.selenium.WebDriver;
public interface Condicoes <T>  extends Function<WebDriver, T>, java.util.function.Function<WebDriver, T> {}
