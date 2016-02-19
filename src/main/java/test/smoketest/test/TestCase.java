package test.smoketest.test;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by mikhail.kutuzov on 18.02.2016.
 */
public abstract class TestCase {

    public abstract String getName();

    public abstract String getDescription();

    protected abstract void test();

    /**
     * Время исполнения теста в секундах.
     * @throws TestResult исключение времени исполнения теста
     * @return
     */
    public TestResult action() {
        Instant begin = Instant.now();
        try {
            test();
            return new TestResult((int) Duration.between(begin, Instant.now()).getSeconds(), "");
        } catch (Exception e) {
            return new TestResult((int) Duration.between(begin, Instant.now()).getSeconds(), e.getMessage());
        }
    }
}
