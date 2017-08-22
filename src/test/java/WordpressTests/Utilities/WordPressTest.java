package WordpressTests.Utilities;

import WordpressAutomation.Selenium.Driver;
import WordpressAutomation.Pages.LoginPage;
import org.junit.After;
import org.junit.Before;

/**
 * Created by oleh on 21.08.17.
 */
public class WordPressTest {

    @Before
    public void Init() {
        Driver.Initialize();

        LoginPage.GoTo();
        LoginPage.LoginAs("olur_7@ukr.net").WithPassword("Di@n@3210").Login();
    }

    @After
    public void TearDown() {
        Driver.Close();
    }
}
