package test.smoketest.core;

import org.openqa.selenium.WebDriver;

public class PageBase {
    private WebDriver driver;
    private String pageUrl;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

}
