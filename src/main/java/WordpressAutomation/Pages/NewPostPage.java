package WordpressAutomation.Pages;


import WordpressAutomation.Selenium.Driver;
import WordpressAutomation.Navigation.LeftNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.List;


public class NewPostPage {

    public static void GoTo() {
        LeftNavigation.Posts.AddNew.Select();
    }

    public static CreatePostCommand CreatePost(String title) {
        return new CreatePostCommand(title);

    }

    public static void GoToNewPost() {

            WebElement message = Driver.Instance.findElement(By.id("message"));
            WebElement newPostlink = message.findElements(By.tagName("a")).get(0);
            newPostlink.click();

    }

    public static boolean IsInEditMode() {

        List <WebElement> h1s = Driver.Instance.findElements(By.tagName("h1"));
        if (! h1s.isEmpty())
        return h1s.get(0).getText().equals("Edit Page");

        return false;
    }

    public static String getTitle() {
        WebElement title = Driver.Instance.findElement(By.id("title"));
        if (title != null)
            return title.getAttribute("value");
        return  "";
    }


    public  static class CreatePostCommand {
        private String title;
        private String body;


        public CreatePostCommand(String title) {
            this.title = title;
        }

        public CreatePostCommand WithBody(String body) {
            this.body = body;
            return this;
        }

        public void Publish() throws Exception{


                Driver.Instance.findElement(By.id("title")).sendKeys(title);
                Driver.Instance.findElement(By.id("content-tmce")).click();
                Driver.Instance.switchTo().frame("content_ifr");
                Driver.Instance.switchTo().activeElement().sendKeys(body);
                Driver.Instance.switchTo().defaultContent();

                Driver.Wait(1);
                Driver.Instance.findElement(By.id("publish")).click();

        }
    }




}
