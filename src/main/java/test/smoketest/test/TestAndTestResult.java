package test.smoketest.test;

/**
 * Created by mikhail.kutuzov on 18.02.2016.
 */
public class TestAndTestResult {
    private TestCase test;
    private TestResult result;

    public TestAndTestResult(TestCase test, TestResult result) {
        this.test = test;
        this.result = result;
    }

    public TestCase getTest() {
        return test;
    }

    public TestResult getResult() {
        return result;
    }
}
