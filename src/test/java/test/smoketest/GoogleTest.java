package test.smoketest;

import org.junit.Test;
import test.smoketest.core.Navigator;
import test.smoketest.core.ProjectNavigator;
import test.smoketest.core.WebBrowsers;
import test.smoketest.utils.DeterminateExtensionResource;
import test.smoketest.utils.ExecutableResource;
import test.smoketest.utils.ProduceChromeDriver;
import test.smoketest.utils.SingleFileByPath;

import java.io.File;

/**
 * Created by mikhail.kutuzov on 19.02.2016.
 */
public class GoogleTest {

    @Test
    public void open(){
        new ProduceChromeDriver(new DeterminateExtensionResource(new ExecutableResource(new SingleFileByPath())))
                .create("chromedriver", new File("chromedriver.exe"));
        Navigator navigator = new ProjectNavigator(WebBrowsers.Chrome, "http://google.com/");
        try {
            GooglePage mainPage = navigator.open(GooglePage.class);
            mainPage.getLogo().click();
        } finally {
            navigator.close();
        }
    }

}
