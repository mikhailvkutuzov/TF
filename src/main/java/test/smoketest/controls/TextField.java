package test.smoketest.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class TextField extends ControlBase {
    public TextField(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public void setText(String text)
    {

        getSelenium().findElement(By.xpath(selector)).sendKeys(text);
    }

    @Override
    public String toString()
    {
        return getSelenium().findElement(By.xpath(selector)).getText();
    }

    public void click()
    {
        getSelenium().findElement(By.xpath(selector)).click();
    }

    public String getSelector()
    {
        return selector;
    }

    public void clearText()
    {
        getSelenium().findElement(By.xpath(selector)).clear();
    }
}
