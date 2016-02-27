package test.smoketest.controls;

import org.openqa.selenium.WebDriver;
import test.smoketest.core.Navigator;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 28.02.2016.
 */
public abstract class NewPageButton extends Button {
    private Navigator navigator;

    public NewPageButton(Navigator navigator, WebDriver selenium, String selector) {
        super(selenium, selector);
        this.navigator = navigator;
    }

    @Override
    protected PageBase getPage() {
        return navigator.navigate(getPageClass());
    }

    protected abstract Class<? extends PageBase> getPageClass();
}
