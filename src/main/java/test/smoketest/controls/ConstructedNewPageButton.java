package test.smoketest.controls;

import test.smoketest.core.Navigator;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 28.02.2016.
 */
public class ConstructedNewPageButton extends NewPageButton {
    private Class<? extends PageBase> page;

    public ConstructedNewPageButton(Navigator navigator, String selector, Class<? extends PageBase> page) {
        super(navigator.getDriver(), navigator, selector);
        this.page = page;
    }

    /**
     * Для тог чттобвенуть окошко котрое сущесвуевпределах другопрложения
     * @param currentNavigator текущее приложение
     * @param nextNavigator описание открываемого приложения
     * @param selector описатель кнопки в текущем приложении
     * @param page класс страницы открываемого приложения
     */
    public ConstructedNewPageButton(Navigator currentNavigator, Navigator nextNavigator, String selector, Class<? extends PageBase> page) {
        super(currentNavigator.getDriver(), nextNavigator, selector);
        this.page = page;
    }


    @Override
    protected Class<? extends PageBase> getPageClass() {
        return page;
    }
}
