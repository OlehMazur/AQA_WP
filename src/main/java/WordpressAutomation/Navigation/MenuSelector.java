package WordpressAutomation.Navigation;

import WordpressAutomation.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by oleh on 22.08.17.
 */
public class MenuSelector {
    public static void Select(String topLevelMenuId, String subMenuLinkText) throws  Exception{



        Driver.Instance.findElement(By.id(topLevelMenuId)).click();
        Thread.sleep(7000);

        Driver.Instance.findElement(By.linkText(subMenuLinkText)).click();
    }
}
