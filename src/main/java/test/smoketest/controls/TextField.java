package test.smoketest.controls;

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

        getSelenium().until(getElement).sendKeys(text);
    }

    @Override
    public String toString()
    {
        return getSelenium().until(getElement).getText();
    }

    public void click()
    {
        getSelenium().until(getElement).click();
    }

    public String getSelector()
    {
        return selector;
    }

    public void clearText()
    {
        getSelenium().until(getElement).clear();
    }
}
