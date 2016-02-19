package test.smoketest;

import test.smoketest.controls.Button;
import test.smoketest.core.PageBase;

/**
 * Created by mikhail.kutuzov on 19.02.2016.
 */
public class GooglePage  extends PageBase{

    public Button getLogo(){
        return new Button(getDriver(), ".//*[@id='hplogo']");
    }

}
