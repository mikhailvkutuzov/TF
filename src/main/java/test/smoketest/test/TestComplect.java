package test.smoketest.test;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mikhail.kutuzov on 18.02.2016.
 */
public abstract class TestComplect {

    public abstract String getName();

    public abstract String getDescription();

    public abstract List<TestCase> getTestCases();


    public List<TestAndTestResult> action(){
        return getTestCases()
                .stream()
                .map(t -> new TestAndTestResult(t, t.action()))
                .collect(Collectors.toList());
    }
}
