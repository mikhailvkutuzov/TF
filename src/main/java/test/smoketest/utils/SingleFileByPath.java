package test.smoketest.utils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

/**
 * This class intended to create file from a single project resource.
 * It makes a file executable and readable by anyone according with POSIX.
 * <p>
 * Created by mikhail.kutuzov on 26.11.2016.
 */
public class SingleFileByPath implements FileFromResource {

    @Override
    public void create(String resource, File path) {
        BufferedInputStream input = new BufferedInputStream(SingleFileByPath.class.getClassLoader().getResourceAsStream(resource));
        BufferedOutputStream output = null;
        try {
            output = new BufferedOutputStream(new FileOutputStream(path));
            int i;
            while ((i = input.read()) != -1) {
                try {
                    output.write(i);
                } catch (IOException e) {
                    throw new WritingError();
                }
            }
            Set<PosixFilePermission> permissions = new HashSet<>();
            permissions.add(PosixFilePermission.OWNER_READ);
            permissions.add(PosixFilePermission.OWNER_EXECUTE);
            permissions.add(PosixFilePermission.OTHERS_READ);
            permissions.add(PosixFilePermission.OTHERS_EXECUTE);
            Files.setPosixFilePermissions(path.toPath(), permissions);
        } catch (FileNotFoundException e) {
            throw new UnknownError();
        } catch (IOException e) {
            path.delete();
            throw new ReadingError(e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                throw new CouldNotClose();
            } finally {
                try {
                    if (output != null) {
                        output.close();
                    }
                } catch (IOException e) {
                    throw new CouldNotClose();
                }
            }
        }
    }

    private static final class WritingError extends RuntimeException {
    }

    private static final class ReadingError extends RuntimeException {
        ReadingError(Throwable cause) {
            super(cause);
        }
    }

    private static final class CouldNotClose extends RuntimeException {
    }

    private static final class UnknownError extends RuntimeException {
    }

}
