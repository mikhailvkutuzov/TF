package test.smoketest.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

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
            throw new RuntimeException(e);
        }
    }

    public <T extends PageBase> T open(Class<T> template) {
        try {
            T t = create(template, url);
            driver.navigate().to(new URL(t.getUrl()));
            return t;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
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
        return target;
    }
}
