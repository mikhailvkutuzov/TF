package test.smoketest.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import test.smoketest.controls.ControlBase;

public interface Navigator {

    /**
     * Открыть страницу наследующую PageBase в приложении с адресом urlParameters.
     * @param template класс страницы
     * @param url URL адрес приложения
     * @param <T> объект через который осоуществляется доступ к открывшейся странице.
     * @return
     */
    <T extends PageBase> T open(Class<T> template, String url);

    /**
     * Открыть страницу наследующую PAgeBase в приложени по умолчанию.
     * @param template класс страницы
     * @param <T> объект через который осоуществляется доступ к открывшейся странице.
     * @return
     */
    <T extends PageBase> T open(Class<T> template);

    /**
     * Для уже открытой страницы создадим PageBase.
     * @param template
     * @param action
     * @param <T>
     * @return
     */
    <T extends PageBase> T navigate(Class<T> template, Action action);

    <T extends PageBase> T navigate(Class<T> template);

    WebDriver getDriver();

    /**
     * Дождаться установки аттрибута элемента element в некоторое значение.
     * @param element
     * @param name имя аттрибута
     * @param value значение которое содержится в аттрибуте
     * @param seconds количество секунд которое будем пытаться получить значение
     * @return false  - если за время seconds секунд не нашли значение, иначе - true
     */
    boolean waitForAnAttribute(ControlBase element, String name, String value, int seconds);

}
