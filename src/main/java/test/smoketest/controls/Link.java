package test.smoketest.controls;

import org.openqa.selenium.WebDriver;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class Link extends ControlBase {
    public Link(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public void click()
    {
        getSelenium().until(getElement).click();
    }

    public String getTextLink()
    {
        return getSelenium().until(getElement).getText();
    }
}
