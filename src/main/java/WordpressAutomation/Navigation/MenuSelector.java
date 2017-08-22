package WordpressAutomation.Navigation;

import WordpressAutomation.Selenium.Driver;
import org.openqa.selenium.By;

/**
 * Created by oleh on 22.08.17.
 */
public class MenuSelector {
    public static void Select(String topLevelMenuId, String subMenuLinkText) {
        Driver.Instance.findElement(By.id(topLevelMenuId)).click();
        Driver.Instance.findElement(By.linkText(subMenuLinkText)).click();
    }
}
