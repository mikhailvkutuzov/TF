package test.smoketest.controls;

import test.smoketest.core.Navigator;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 28.02.2016.
 */
public class ConstructedNewPageButton extends NewPageButton {
    private Class<? extends PageBase> page;

    public ConstructedNewPageButton(Navigator navigator, String selector, Class<? extends PageBase> page) {
        super(navigator, selector);
        this.page = page;
    }

    @Override
    protected Class<? extends PageBase> getPageClass() {
        return page;
    }
}
