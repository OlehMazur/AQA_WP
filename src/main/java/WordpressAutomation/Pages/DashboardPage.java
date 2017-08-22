package WordpressAutomation.Pages;

import WordpressAutomation.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by oleh on 19.08.17.
 */
public class DashboardPage {

    public static Boolean IsAt () {

        List <WebElement> textInput = Driver.Instance.findElements(By.tagName("h1"));
        if (!textInput.isEmpty())
            return textInput.get(0).getText().equals("Dashboard") ;

        return false;
    }

}
