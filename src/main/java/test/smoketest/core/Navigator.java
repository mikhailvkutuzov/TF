package test.smoketest.core;

import org.openqa.selenium.interactions.Action;

public interface Navigator {

    <T extends PageBase> T open(Class<T> template, String urlParameters);

    <T extends PageBase> T navigate(Class<T> template, Action action);
}
