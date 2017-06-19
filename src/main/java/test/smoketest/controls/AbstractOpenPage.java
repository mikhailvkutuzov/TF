package test.smoketest.controls;

import org.openqa.selenium.WebDriver;
import test.smoketest.core.PageBase;

import java.util.Set;

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
        WebDriver driver = getPage().getDriver();
        Set<String> oldWindows = driver.getWindowHandles();
        getSelenium().until(getElement).click();
        Set<String> newWindows = driver.getWindowHandles();
        newWindows.removeAll(oldWindows);
        String openedWindow = newWindows.iterator().next();
        driver.switchTo().window(openedWindow);
        return getPage();
    }

    protected abstract PageBase getPage();
}
