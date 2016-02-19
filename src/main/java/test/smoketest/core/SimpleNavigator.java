package test.smoketest.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by mkutuzov on 04.01.2016.
 */
public class SimpleNavigator implements Navigator {
    private WebDriver driver;
    private Dimension size = new Dimension(1600, 900);

    public SimpleNavigator(WebBrowsers browser) {
        switch (browser) {
            case Chrome:
                driver = new ChromeDriver();
                break;
            case Firefox:
                driver = new FirefoxDriver();
                break;
            case InternetExplorer:
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().window().setSize(size);
    }

    @Override
    public <T extends PageBase> T open(Class<T> template, String urlParameters) {
        try {
            T t = create(template);
            t.setPageUrl(urlParameters);
            t.setDriver(driver);
            driver.navigate().to(new URL(t.getPageUrl()));
            return t;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
    }

    public <T extends PageBase> T open(Class<T> template) {
        try {
            T t = create(template);
            t.setDriver(driver);
            driver.navigate().to(new URL(t.getPageUrl()));
            return t;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
    }


    private <T extends PageBase> T create(Class<T> template) {
        try {
            T t = template.newInstance();
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public <T extends PageBase> T navigate(Class<T> template, Action action) {
        T target = create(template);
        target.setDriver(driver);
        action.perform();
        waitLoad();
        assertErrorPage(target);
        assertCorrectPageLoaded(target);
        return target;
    }

    private void waitLoad() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private  static <T extends PageBase> void assertCorrectPageLoaded(T target) {
        String location = target.getDriver().getCurrentUrl();
        int paramsStart = location.indexOf('?');

        if (paramsStart >= 0) {
            location = location.substring(0, paramsStart);
        }

        if (!location.endsWith(target.getPageUrl())) {
            throw new RuntimeException("Expected URL " + target.getPageUrl() + "  but was " + location);
        }
    }

    private static <T extends PageBase> void assertErrorPage(T target) {
        String bodyText = target.getDriver().findElement(By.tagName("body")).getText();
        if (bodyText.contains("Server Error in "))
        {
            throw new RuntimeException("Server error while navigating\r\n\r\n " + bodyText);
        }
    }

}
