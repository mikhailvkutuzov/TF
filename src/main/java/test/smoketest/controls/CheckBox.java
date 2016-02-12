package test.smoketest.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class CheckBox extends ControlBase {
    public CheckBox(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public boolean getValue() {
        return Boolean.parseBoolean(getSelenium().findElement(By.xpath(selector)).getAttribute("value"));
    }

    public void setValue(boolean check) {
        if (getValue() != check) {
            getSelenium().findElement(By.xpath(selector)).click();
        }
    }

    public void click() {
        getSelenium().findElement(By.xpath(selector)).click();
    }
}
