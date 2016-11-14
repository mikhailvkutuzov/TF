package test.smoketest.controls;

import org.openqa.selenium.WebDriver;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class CheckBox extends ControlBase {
    public CheckBox(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public boolean getValue() {
        return Boolean.parseBoolean(getSelenium().until(getElement).getAttribute("value"));
    }

    public void setValue(boolean check) {
        if (getValue() != check) {
            getSelenium().until(getElement).click();
        }
    }

    public void click() {
        getSelenium().until(getElement).click();
    }
}
