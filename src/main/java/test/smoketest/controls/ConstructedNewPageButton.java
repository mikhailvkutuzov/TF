package test.smoketest.controls;

import org.openqa.selenium.WebDriver;
import test.smoketest.core.Navigator;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 28.02.2016.
 */
public class ConstructedNewPageButton extends NewPageButton {
    private Class<? extends PageBase> page;

    public ConstructedNewPageButton(Navigator navigator, WebDriver selenium, String selector, Class<? extends PageBase> page) {
        super(navigator, selenium, selector);
        this.page = page;
    }

    @Override
    protected Class<? extends PageBase> getPageClass() {
        return page;
    }
}
