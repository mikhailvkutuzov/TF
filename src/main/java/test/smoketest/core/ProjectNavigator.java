package test.smoketest.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Класс отвечает за открытие и создание страниц в проекте.
 * Created by mkutuzov on 04.01.2016.
 */
public class ProjectNavigator implements Navigator {
    private WebDriver driver;
    private Dimension size = new Dimension(1600, 900);
    private String url;

    public ProjectNavigator(WebBrowsers browser, String url) {
        this.url = url;
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
    public <T extends PageBase> T open(Class<T> template, String url) {
        try {
            T t = create(template, url);
            driver.navigate().to(new URL(t.getUrl()));
            return t;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
    }

    public <T extends PageBase> T open(Class<T> template) {
        try {
            T t = create(template, url);
            driver.navigate().to(new URL(t.getUrl()));
            return t;
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException();
        }
    }


    private <T extends PageBase> T create(Class<T> template, String projectUrl) {
        try {
            Class[] parameters = new Class[2];
            parameters[0] = WebDriver.class;
            parameters[1] = String.class;
            return template.getDeclaredConstructor(parameters).newInstance(driver, projectUrl);
        } catch (InstantiationException | IllegalAccessException
                 |NoSuchMethodException |InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T extends PageBase> T navigate(Class<T> template, Action action) {
        T target = create(template, url);
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

        if (!location.equals(target.getUrl())) {
            throw new RuntimeException("Expected URL " + target.getUrl() + "  but was " + location);
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
