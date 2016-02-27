package test.smoketest.controls;

import org.openqa.selenium.WebDriver;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 28.02.2016.
 */
public class TheSamePageButton extends Button {
    private PageBase page;

    public TheSamePageButton(PageBase page, WebDriver selenium, String selector) {
        super(selenium, selector);
        this.page = page;
    }

    @Override
    protected PageBase getPage() {
        return page;
    }
}
