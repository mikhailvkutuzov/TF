package test.smoketest.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 24.11.2016.
 */
public abstract class AbstractOpenPage extends ControlBase implements OpenPage {

    public AbstractOpenPage(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public PageBase clickSameTab()
    {
        click();
        return getPage();
    }

    public PageBase clickNewTab() {
        getSelenium().until(getElement).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        return getPage();
    }

    protected abstract PageBase getPage();
}
