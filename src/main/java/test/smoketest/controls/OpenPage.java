package test.smoketest.controls;

import test.smoketest.core.PageBase;

/**
 * Интерфейс для открытия новой страницы по клику на элемент.
 * Created by mikhail.kutuzov on 24.11.2016.
 */
public interface OpenPage {
    PageBase clickSameTab();
    PageBase clickNewTab();
}
