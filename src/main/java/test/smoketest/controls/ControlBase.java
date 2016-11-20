package test.smoketest.controls;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by mkutuzov on 04.01.2016.
 */

public class ControlBase {
    private WebDriver driver;
    private WebDriverWait selenium;
    protected String selector;

    public ControlBase(WebDriver selenium, String selector) {
        this.driver = selenium;
        this.selenium = new WebDriverWait(selenium, 10);
        this.selector = selector;
    }

    protected Function<WebDriver, WebElement> getElement = i -> i.findElement(By.xpath(selector));
    protected Function<WebDriver, List<WebElement>> getElements = i -> i.findElements(By.xpath(selector));

    protected WebDriverWait getSelenium() {
        return selenium;
    }

    public String getValueAttribute(String n) {
        return selenium.until(getElement).getAttribute(n);
    }

    public boolean isVisible() {
        return selenium.until(getElement).isDisplayed();
    }

    public boolean isCreated() {
        boolean existenceElement = false;

        List<WebElement> elements = selenium.until(getElements);
        if (elements.size() == 1) {
            existenceElement = true;
        }
        if (elements.size() > 1) {
            throw new RuntimeException("Ошибка проверки существования элемента с селектором - '" + selector + "'. Было найдено несколько элементов, вместо одного. Необходимо уточнить XPATH элемента.");
        }
        return existenceElement;
    }

    public void click() {
        getSelenium().until(getElement).click();
    }

    public int amountOfElements() {
        return selenium.until(getElements).size();
    }

    public void mouseOnElement() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(selector))).build().perform();
    }
}