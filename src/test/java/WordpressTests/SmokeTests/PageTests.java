package WordpressTests.SmokeTests;

import WordpressAutomation.Pages.ListPostsPage;
import WordpressAutomation.Pages.NewPostPage;
import WordpressAutomation.Pages.PostType;
import WordpressTests.Utilities.WordPressTest;
import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Created by oleh on 21.08.17.
 */
public class PageTests extends WordPressTest {


    @Test
    public void Can_Go_To_Edit_Mode_For_Pages() {

        ListPostsPage.GoTo(PostType.Page);
        ListPostsPage.SelectPost("Контакти");
        assertTrue("Wasn't in edit mode", NewPostPage.IsInEditMode());
        assertEquals("Title did not match", "Контакти", NewPostPage.getTitle());
    }


}
