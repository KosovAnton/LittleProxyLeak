import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.net.NetworkUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.*;

public class BaseTest {
    protected static Map<String, String> responses = new HashMap<>();

    @BeforeSuite
    public void beforeSuiteMethod() {
        Configuration.proxyEnabled = true;
        Configuration.proxyHost = new NetworkUtils().getNonLoopbackAddressOfThisMachine();
    }

    @BeforeMethod
    public void beforeTestMethod() {
        open("https://en.wikipedia.org/");
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @AfterMethod
    public void afterTestMethod() {
        clearBrowserCookies();
        clearBrowserLocalStorage();
        closeWindow();
    }
}
