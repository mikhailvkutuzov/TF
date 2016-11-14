package test.smoketest.controls;

import org.openqa.selenium.WebDriver;
import test.smoketest.core.PageBase;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public abstract class Button extends ControlBase {

    public Button(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public PageBase click()
    {
        getSelenium().until(getElement).click();
        return getPage();
    }

    /**
     * Вернуть страницу которая открывается по нажатию на кнопку.
     * @return
     */
    protected abstract PageBase getPage();

    public String getText()
    {
        return getSelenium().until(getElement).getText();
    }

}
