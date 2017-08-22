package WordpressTests.SmokeTests;

import WordpressAutomation.Pages.NewPostPage;
import WordpressAutomation.Pages.PostPage;
import WordpressTests.Utilities.WordPressTest;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CreatePostTests extends WordPressTest {

    @Test
    public void Can_Create_A_Basic_Post() throws  Exception {
        NewPostPage.GoTo();
        NewPostPage.CreatePost("This is the post title").WithBody("Hi, this is the body").Publish();
        NewPostPage.GoToNewPost();
        assertEquals("Title did not match new post !", "This is the post title", PostPage.getTitle());

    }



}
