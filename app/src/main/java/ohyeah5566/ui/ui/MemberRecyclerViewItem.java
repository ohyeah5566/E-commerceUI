package ohyeah5566.ui.ui;

/**
 * Created by yiwei on 2018/12/19.
 */
public class MemberRecyclerViewItem {
    int imageId;
    String title;
    String actionName;
// TODO: 2018/12/19 Action  //點擊此View時 要實現的動作。

    public MemberRecyclerViewItem(int imageId, String title, String actionName) {
        this.imageId = imageId;
        this.title = title;
        this.actionName = actionName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getTitle() {
        return title;
    }

    public String getActionName() {
        return actionName;
    }
}
