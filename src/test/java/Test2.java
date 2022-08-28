import com.codeborne.selenide.proxy.SelenideProxyServer;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.WebDriverRunner.getSelenideProxy;

public class Test2 extends BaseTest {
    @Test
    public void test2() {
        SelenideProxyServer proxy = getSelenideProxy();
        proxy.addResponseFilter("resp1", (response, contents, messageInfo) -> {
            HttpRequest request = messageInfo.getOriginalRequest();
            if (request.uri().equals("uri") && request.method().equals(HttpMethod.POST)) {
                responses.put("uri", contents.getTextContents());
            }
        });
        

    }
}
