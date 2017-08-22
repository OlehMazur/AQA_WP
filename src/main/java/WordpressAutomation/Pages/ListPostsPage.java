package WordpressAutomation.Pages;
import WordpressAutomation.Selenium.Driver;
import WordpressAutomation.Navigation.LeftNavigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


/**
 * Created by oleh on 21.08.17.
 */
public class ListPostsPage {

    private static int lastCount;

    public static int getPreviousPostCount() {
        return lastCount;
    }

    public static int getCurrentPostCount() {
        return GetPostCount();
    }


    public static void GoTo(PostType postType) {
        switch (postType) {
            case Page:
                LeftNavigation.Pages.AllPages.Select();
                break;
            case Posts:
                LeftNavigation.Posts.AllPosts.Select();
                break;
        }

    }

    public static void SelectPost(String title) {
        WebElement postLink = Driver.Instance.findElement(By.linkText(title));
        postLink.click();
    }

    public static void StoreCount() {
        lastCount = GetPostCount();

    }

    private static int GetPostCount() {
        String countText = Driver.Instance.findElement(By.className("displaying-num")).getText();
        return Integer.parseInt(countText.split(" ")[0]);
    }

    public static boolean DoesPostExistWithTitle(String title) {
        return Driver.Instance.findElement(By.linkText(title)).getText().equals(title);
    }

    public static void TrashPost(String title) {
        List<WebElement>  rows = Driver.Instance.findElements(By.tagName("tr"));
        for ( WebElement row : rows) {
            List<WebElement> links = null;
            links = row.findElements(By.linkText(title));

            if (!links.isEmpty()) {
                Actions action = new Actions(Driver.Instance);
                action.moveToElement(links.get(0));
                action.perform();
                row.findElement(By.className("submitdelete")).click();
                return;
            }
        }
    }

    public static void SearchForPost(String searchString) {
        WebElement searchBox = Driver.Instance.findElement(By.id("post-search-input"));
        searchBox.sendKeys(searchString);

        WebElement searchButton = Driver.Instance.findElement(By.id("search-submit"));
        searchButton.click();

    }
}

