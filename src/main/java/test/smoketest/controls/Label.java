package test.smoketest.controls;

import org.openqa.selenium.WebDriver;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class Label extends ControlBase {
    public Label(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public String getText()
    {
        return getSelenium().until(getElement).getText();
    }

    public String getSelector()
    {
        return selector;
    }

    @Override
    public String toString()
    {
        return "Label with text '" + getText() + "'";
    }
}
