package WordpressAutomation.Pages;

import WordpressAutomation.Selenium.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by oleh on 19.08.17.
 */
public class LoginPage {

    private static WebDriver driver;

    public static void GoTo() {
        Driver.Instance.navigate().to(Driver.getBaseAddress());
        WebDriverWait wait = new WebDriverWait(Driver.Instance, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.is-primary")));
    }

    public static LoginCommand LoginAs(String userName) {
        return  new LoginCommand(userName);
    }


    public  static class LoginCommand {
        private String userName;
        private String password;

        public LoginCommand(String userName) {
            this.userName = userName;
        }

        public LoginCommand WithPassword(String password) {
            this.password = password;
            return this;
        }

        public void Login() {
          WebElement loginInput =  Driver.Instance.findElement(By.id("usernameOrEmail"));
          loginInput.sendKeys(userName);

          WebElement passwordInput = Driver.Instance.findElement(By.id("password"));
          passwordInput.sendKeys(password);

          WebElement loginButton = Driver.Instance.findElement(By.cssSelector("button.is-primary"));
          loginButton.click();

        }
    }
}
