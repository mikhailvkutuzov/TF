package test.smoketest.test;

import test.smoketest.core.WebBrowsers;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mikhail.kutuzov on 18.02.2016.
 */
public abstract class TestComplect {

    public abstract String getName();

    public abstract String getDescription();

    public abstract List<TestCase> getTestCases();


    public List<TestAndTestResult> action(WebBrowsers browser, String url){
        return getTestCases()
                .stream()
                .map(t -> new TestAndTestResult(t, t.action(browser, url)))
                .collect(Collectors.toList());
    }
}
