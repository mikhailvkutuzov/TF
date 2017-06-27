package test.smoketest.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * To set POSIX properties for non Windows operational systems
 *
 * Created by mikhail kutuzov on 27.06.2017.
 */
public class ExecutableResource implements FileFromResource {
    private FileFromResource delegate;

    public ExecutableResource(FileFromResource delegate) {
        this.delegate = delegate;
    }

    @Override
    public void create(String resource, File path) {
        delegate.create(resource, path);

        if (!System.getProperty("os.name").startsWith("Windows")) {
            Set<PosixFilePermission> permissions = new HashSet<>();
            permissions.add(PosixFilePermission.OWNER_READ);
            permissions.add(PosixFilePermission.OWNER_EXECUTE);
            permissions.add(PosixFilePermission.OTHERS_READ);
            permissions.add(PosixFilePermission.OTHERS_EXECUTE);
            try {
                Files.setPosixFilePermissions(path.toPath(), permissions);
            } catch (IOException e) {
                throw new WritingError();
            }
        }
    }
}
