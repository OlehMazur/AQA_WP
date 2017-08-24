package WordpressTests.PostsTests;

import WordpressAutomation.Pages.ListPostsPage;
import WordpressAutomation.Pages.NewPostPage;
import WordpressAutomation.Pages.PostType;
import WordpressTests.Utilities.WordPressTest;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by oleh on 22.08.17.
 */
public class AllPostsTest extends WordPressTest {

    @Test
    public void Added_Posts_Show_Up() throws Exception{
        ListPostsPage.GoTo(PostType.Posts);
        ListPostsPage.StoreCount();

        NewPostPage.GoTo();
        NewPostPage.CreatePost("Added posts show up, title")
                .WithBody("Added posts show up, body")
                .Publish();

        ListPostsPage.GoTo(PostType.Posts);

        assertEquals("Count of posts did not increase !" ,ListPostsPage.getPreviousPostCount()+1, ListPostsPage.getCurrentPostCount());

        assertTrue(ListPostsPage.DoesPostExistWithTitle("Added posts show up, title"));

        ListPostsPage.TrashPost("Added posts show up, title");

        assertEquals("Couldn't trash post !",ListPostsPage.getPreviousPostCount(), ListPostsPage.getCurrentPostCount());

    }


//    @Test
//    public void Can_Search_Posts() throws Exception {
//        NewPostPage.GoTo();
//        NewPostPage.CreatePost("Searching posts, title")
//                .WithBody("Searching post, body")
//                .Publish();
//
//        ListPostsPage.GoTo(PostType.Posts);
//        ListPostsPage.SearchForPost("Searching posts, title");
//        assertTrue(ListPostsPage.DoesPostExistWithTitle("Searching posts, title"));
//        ListPostsPage.TrashPost("Searching posts, title");
//
//    }


}
