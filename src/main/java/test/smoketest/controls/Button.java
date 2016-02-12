package test.smoketest.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class Button extends ControlBase {

    public Button(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public void click()
    {
        getSelenium().findElement(By.xpath(selector)).click();
    }

    public String getText()
    {
        return getSelenium().findElement(By.xpath(selector)).getText();
    }

}
