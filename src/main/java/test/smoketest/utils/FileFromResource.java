package test.smoketest.utils;

import java.io.File;

/**
 * Производим для работающего приложения драйвер доступный процессу {@link org.openqa.selenium.WebDriver}
 * из фаиловой системы.
 * Created by mikhail.kutuzov on 26.11.2016.
 */
public interface FileFromResource {

    /**
     * Произвести файл.
     * @param resource имя ресурса
     * @param path путь до файла
     */
    void create(String resource, File path);

}
