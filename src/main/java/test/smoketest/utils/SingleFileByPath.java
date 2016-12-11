package test.smoketest.utils;

import java.io.*;

/**
 * Created by mikhail.kutuzov on 26.11.2016.
 */
public class SingleFileByPath implements FileFromResource {

    @Override
    public void create(String resource, File path) {
        BufferedInputStream input =  new BufferedInputStream(SingleFileByPath.class.getClassLoader().getResourceAsStream(resource));
        BufferedOutputStream output = null;
        try {
            output =  new BufferedOutputStream(new FileOutputStream(path));
            int i;
            while ((i = input.read()) != -1) {
                try {
                    output.write(i);
                } catch (IOException e) {
                    throw new WritingError();
                }
            }
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
                    output.close();
                } catch (IOException e) {
                    throw new CouldNotClose();
                }
            }
        }
    }

    public static final class WritingError extends RuntimeException {}

    public static final class ReadingError extends RuntimeException {
        public ReadingError(Throwable cause) {
            super(cause);
        }
    }

    public static final class CouldNotClose extends RuntimeException {}

    public static final class UnknownError extends RuntimeException {}

}
