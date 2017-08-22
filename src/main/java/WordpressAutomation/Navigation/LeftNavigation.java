package WordpressAutomation.Navigation;

/**
 * Created by oleh on 22.08.17.
 */
public class LeftNavigation {
    public static class Posts {
        public static class AddNew {
            public static void Select() {
                MenuSelector.Select("menu-posts", "Add New");
            }
        }

        public static class AllPosts {

            public static void Select() {
                MenuSelector.Select("menu-posts", "All Posts");
            }
        }
    }

    public static class Pages {
        public static class AllPages {
            public static void Select() {
                MenuSelector.Select("menu-pages", "All Pages");
            }
        }
    }


}