import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseConfig {


    @BeforeAll
    void config() {
        Configuration.browserSize = "1920x1080";
    }
}
