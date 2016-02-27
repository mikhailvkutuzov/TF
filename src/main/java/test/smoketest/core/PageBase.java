package test.smoketest.core;

import org.openqa.selenium.WebDriver;

/**
 * Расширения этого класса содержат в себе код для доступа к
 * элментам html страницы.
 */
public abstract class PageBase {
    private WebDriver driver;
    private String projectUrl;

    /**
     * Для создания страницы нужен WebDriver и url проекта.
     * @param driver
     * @param projectUrl
     */
    public PageBase(WebDriver driver, String projectUrl) {
        this.driver = driver;
        this.projectUrl = projectUrl;
    }

    /**
     * Вернуть WebDriver в котором открылась страница.
     * @return
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Вернуть url страницы относительно корневого элемента проекта.
     * @return
     */
    protected abstract String getRelativeUrl();

    /**
     * Вернуть полный url страницы.
     * @return
     */
    public String getUrl(){
        return projectUrl + getRelativeUrl();
    }

}
