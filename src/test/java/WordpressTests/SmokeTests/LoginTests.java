package WordpressTests.SmokeTests;

import WordpressAutomation.Pages.DashboardPage;
import WordpressTests.Utilities.WordPressTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by oleh on 19.08.17.
 */
public class LoginTests extends WordPressTest {

    @Test
    public void Admin_User_Can_Login() {
        assertTrue("Failed to login", DashboardPage.IsAt());
    }


}




