package initialization; // Инициализация тестов

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;


abstract public class BaseTest {

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.headless = false;
        Configuration.holdBrowserOpen = false;
    }

    @BeforeClass
    public static void init(){
        setUp();
    }

    @AfterClass
    public static void tearDown(){
        Selenide.closeWebDriver();
    }

}
