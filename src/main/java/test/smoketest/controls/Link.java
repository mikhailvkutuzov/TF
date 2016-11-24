package test.smoketest.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import test.smoketest.core.PageBase;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public abstract class Link extends AbstractOpenPage implements TextContentElement {
    public Link(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    @Override
    public String getText() {
        return getSelenium().until(getElement).getText();
    }

    public PageBase clickNewTab() {
        getSelenium().until(getElement).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
        return getPage();
    }

    public String getREference() {
        return getSelenium().until(getElement).getAttribute("href");
    }

    /**
     * Вернуть страницу которая открывается по нажатию на кнопку.
     * @return
     */
    protected abstract PageBase getPage();

}
