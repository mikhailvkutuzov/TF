package test.smoketest.test;

/**
 * Created by mikhail.kutuzov on 18.02.2016.
 */
public class TestResult {
    private int time;
    private String message;

    public TestResult(int time, String message) {
        this.time = time;
        this.message = message;
    }

    public int getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }
}
