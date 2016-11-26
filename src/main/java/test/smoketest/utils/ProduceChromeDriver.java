package test.smoketest.utils;

import java.io.File;

/**
 * Загрузим ссылку на созданный файл в переменную webdriver.chrome.driver.
 * Created by mikhail.kutuzov on 26.11.2016.
 */
public class ProduceChromeDriver implements FileFromResource {
    FileFromResource producer;

    public ProduceChromeDriver(FileFromResource producer) {
        this.producer = producer;
    }

    @Override
    public void create(String resource, File path) {
        path.deleteOnExit();
        producer.create(resource, path);
        System.setProperty("webdriver.chrome.driver", path.getAbsolutePath());
    }
}
