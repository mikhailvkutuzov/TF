package test.smoketest;

import org.junit.Assert;
import org.junit.Test;
import test.smoketest.utils.*;

import java.io.File;

/**
 * Created by mikhail.kutuzov on 26.11.2016.
 */
public class DriverRetriever {

    @Test
    public void test() {
        File base = new File("src/main/resources/chromedriver.exe");

        Assert.assertTrue(base.exists());
        FileFromResource driver = new SingleFileByPath();
        File file = new File("cromedriver.exe");
        Assert.assertFalse(file.exists());
        File produced = new File("cromedriver.exe");
        produced.deleteOnExit();
        driver.create("chromedriver.exe", produced);

        Assert.assertTrue(file.exists());
        Assert.assertEquals(base.length(), produced.length());
    }

    @Test
    public void chrome(){
        File produced = new File("chromedriver.exe");
        new ProduceChromeDriver(new DeterminateExtensionResource(new ExecutableResource(new SingleFileByPath())))
                .create("chromedriver", produced);
        Assert.assertTrue(produced.exists());
    }

}
