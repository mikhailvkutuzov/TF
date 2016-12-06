package test.smoketest.test;

/**
 * Created by mikhail.kutuzov on 18.02.2016.
 */
public class TestResult {
    private int time;
    private String message;
    private StackTraceElement[] trace;
    private boolean error;

    public TestResult(int time, String message, StackTraceElement[] trace, boolean error) {
        this.time = time;
        this.message = message;
        this.trace = trace;
        this.error = error;
    }

    public int getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public StackTraceElement[] getTrace() {
        return trace;
    }

    public boolean isError() {
        return error;
    }
}
