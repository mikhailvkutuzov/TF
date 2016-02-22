package test.smoketest;

import org.junit.Test;
import test.smoketest.core.Navigator;
import test.smoketest.core.SimpleNavigator;
import test.smoketest.core.WebBrowsers;

/**
 * Created by mikhail.kutuzov on 19.02.2016.
 */
public class GoogleTest {

    @Test
    public void open(){
        System.setProperty("webdriver.chrome.driver", "e:\\drivers\\chromedriver.exe");
        Navigator navigator = new SimpleNavigator(WebBrowsers.Chrome);
        GooglePage mainPage = navigator.open(GooglePage.class, "http://google.com/");
        mainPage.getLogo().click();
        mainPage.getDriver().close();
    }

}
