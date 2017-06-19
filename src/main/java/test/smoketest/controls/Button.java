package test.smoketest.controls;

import org.openqa.selenium.WebDriver;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public abstract class Button extends AbstractOpenPage implements TextContentElement {

    public Button(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public String getText()
    {
        return getSelenium().until(getElement).getText();
    }

}
