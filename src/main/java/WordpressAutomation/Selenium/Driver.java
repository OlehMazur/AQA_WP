package WordpressAutomation.Selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;

/**
 * Created by oleh on 19.08.17.
 */
public class Driver {

    public static WebDriver Instance;
    public static String BaseAddress;

    public static String getBaseAddress() {
        BaseAddress = "http://olaplab.wordpress.com/wp-admin/";
        return BaseAddress;
    }

    public static void Initialize() {

        //System.setProperty("webdriver.chrome.driver", "/home/oleh/TOOLS/chromedriver");
        System.setProperty("webdriver.gecko.driver", "/home/oleh/TOOLS/geckodriver");

        Instance = new FirefoxDriver();

        Instance.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    public static  void Close () {
        Instance.close();
    }

    public static void Wait(int second) throws Exception {
        Thread.sleep(second*1000);
    }

}
