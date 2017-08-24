package WordpressAutomation.Pages;

import WordpressAutomation.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

/**
 * Created by oleh on 21.08.17.
 */
public class PostPage {

    public static String getTitle() {

        try {
            WebElement title = Driver.Instance.findElement(By.className("entry-title"));
            if (title != null)
                return title.getText();


        }
        catch (NoSuchElementException ex)
        {}
        return "";

    }
}
