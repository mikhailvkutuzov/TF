package test.smoketest.utils;

import java.io.File;

/**
 * Created by misha on 04.07.17.
 */
public class DeterminateExtensionResource implements FileFromResource {
    private FileFromResource delegate;

    public DeterminateExtensionResource(FileFromResource delegate) {
        this.delegate = delegate;
    }

    @Override
    public void create(String resource, File path) {
        boolean jre64 = System.getProperty("os.arch").indexOf("64") != -1;
        boolean unixLike = !System.getProperty("os.name").startsWith("Windows");

        if(unixLike) {
            if (jre64) {
                delegate.create(resource + "64", path);
            } else {
                delegate.create(resource + "32", path);
            }
        } else {
            delegate.create(resource + ".exe", path);
        }
    }
}
