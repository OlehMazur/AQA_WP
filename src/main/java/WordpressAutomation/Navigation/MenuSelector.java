package WordpressAutomation.Navigation;

import WordpressAutomation.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by oleh on 22.08.17.
 */
public class MenuSelector {
    public static void Select(String topLevelMenuId, String subMenuLinkText) {



        Driver.Instance.findElement(By.id(topLevelMenuId)).click();
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"menu-posts\"]/ul/li[3]/a")));

        Driver.Instance.findElement(By.linkText(subMenuLinkText)).click();


    }
}
