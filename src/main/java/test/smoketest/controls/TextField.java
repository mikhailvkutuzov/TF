package test.smoketest.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class TextField extends ControlBase implements TextContentElement {
    public TextField(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public void setText(String text)
    {
        getSelenium().until(getElement).sendKeys(text);
    }

    public String getText() {
        WebElement element = getSelenium().until(getElement);
        return element.getText();
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
