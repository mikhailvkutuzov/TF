package test.smoketest.test;

import test.smoketest.core.WebBrowsers;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by mikhail.kutuzov on 18.02.2016.
 */
public abstract class TestCase {

    public abstract String getName();

    public abstract String getDescription();

    protected abstract void test(WebBrowsers browser, String url);

    /**
     * Время исполнения теста в секундах.
     * @throws TestResult исключение времени исполнения теста
     * @return
     */
    public TestResult action(WebBrowsers browser, String url) {
        Instant begin = Instant.now();
        try {
            test(browser, url);
            return new TestResult((int) Duration.between(begin, Instant.now()).getSeconds(), "", new StackTraceElement[0], false);
        } catch (Throwable t) {
            return new TestResult((int) Duration.between(begin, Instant.now()).getSeconds(), t.getMessage(), t.getStackTrace(), true);
        }
    }
}
