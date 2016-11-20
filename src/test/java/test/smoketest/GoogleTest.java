package test.smoketest;

import org.junit.Test;
import test.smoketest.core.Navigator;
import test.smoketest.core.ProjectNavigator;
import test.smoketest.core.WebBrowsers;

/**
 * Created by mikhail.kutuzov on 19.02.2016.
 */
public class GoogleTest {

    @Test
    public void open(){
        System.setProperty("webdriver.chrome.driver", "target/classes/chromedriver.exe");
        Navigator navigator = new ProjectNavigator(WebBrowsers.Chrome, "http://google.com/");
        GooglePage mainPage = navigator.open(GooglePage.class);
        mainPage.getLogo().click();
        mainPage.getDriver().close();
    }

}
