package test.smoketest.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import test.smoketest.core.PageBase;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public abstract class Button extends AbstractOpenPage {

    public Button(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public PageBase clickNewTab() {
        getSelenium().until(getElement).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        return getPage();
    }

    public String getText()
    {
        return getSelenium().until(getElement).getText();
    }

}
