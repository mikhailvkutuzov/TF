package test.smoketest.controls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mkutuzov on 10.01.2016.
 */
public class Dropdown extends ControlBase {
    public Dropdown(WebDriver selenium, String selector) {
        super(selenium, selector);
    }

    public String[] getValues()
    {
            WebElement SelectElement = getSelenium().until(getElement);
            Select select = new Select(SelectElement);
            List<WebElement> options = select.getOptions();
            return options.stream().map(e -> e.getText()).collect(Collectors.toList()).toArray(new String[]{});
    }

    public String getValue() {
            WebElement SelectElement = getSelenium().until(getElement);
            Select select = new Select(SelectElement);
            return select.getFirstSelectedOption().getAttribute("value");
    }

    public void setValue(String value)
        {
            WebElement SelectElement = getSelenium().until(getElement);
            Select select = new Select(SelectElement);
            select.selectByValue(select.getFirstSelectedOption().getAttribute("value") + value);
        }


    @Override
    public String toString()
    {
        return getValue();
    }

    public void selectItem(String itemName)
    {
        WebElement SelectElement = getSelenium().until(getElement);
        Select select = new Select(SelectElement);
        select.selectByVisibleText(itemName);
    }
}
