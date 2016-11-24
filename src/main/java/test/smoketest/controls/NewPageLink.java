package test.smoketest.controls;

import test.smoketest.core.Navigator;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 24.11.2016.
 */
public abstract class NewPageLink extends Link {
    private Navigator navigator;

    public NewPageLink(Navigator navigator, String selector) {
        super(navigator.getDriver(), selector);
        this.navigator = navigator;
    }

    @Override
    protected PageBase getPage() {
        return navigator.navigate(getPageClass());
    }

    protected abstract Class<? extends PageBase> getPageClass();
}
