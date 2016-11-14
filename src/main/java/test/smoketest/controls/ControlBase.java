package test.smoketest.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Created by mkutuzov on 04.01.2016.
 */

public class ControlBase {
    private WebDriver selenium;
    protected String selector;

    public ControlBase(WebDriver selenium, String selector) {
        this.selenium = selenium;
        this.selector = selector;
    }

    protected WebDriver getSelenium() {
        return selenium;
    }

    public String getValueAttribute(String n) {
        return selenium.findElement(By.xpath(selector)).getAttribute(n);
    }

    public boolean isVisible() {
        return selenium.findElement(By.xpath(selector)).isDisplayed();
    }

    public boolean isCreated() {
        boolean existenceElement = false;

        List<WebElement> elements = selenium.findElements(By.xpath(selector));
        if (elements.size() == 1) {
            existenceElement = true;
        }
        if (elements.size() > 1) {
            throw new RuntimeException("Ошибка проверки существования элемента с селектором - '" + selector + "'. Было найдено несколько элементов, вместо одного. Необходимо уточнить XPATH элемента.");
        }
        return existenceElement;
    }

    public int amountOfElements() {
        return selenium.findElements(By.xpath(selector)).size();
    }

    public void mouseOnElement() {
        Actions actions = new Actions(selenium);
        actions.moveToElement(selenium.findElement(By.xpath(selector))).build().perform();
    }
}