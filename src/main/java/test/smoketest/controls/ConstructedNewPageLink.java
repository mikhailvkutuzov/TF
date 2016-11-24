package test.smoketest.controls;

import test.smoketest.core.Navigator;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 24.11.2016.
 */
public class ConstructedNewPageLink extends NewPageLink {
    private Class<? extends PageBase> page;

    public ConstructedNewPageLink(Navigator navigator, String selector, Class<? extends PageBase> page) {
        super(navigator, selector);
        this.page = page;

    }

    @Override
    protected Class<? extends PageBase> getPageClass() {
        return page;
    }

}
