package ohyeah5566.ui.ui;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;


/**
 * Created by yiwei on 2018/12/4.
 */
public class MyPaddingDecoration extends RecyclerView.ItemDecoration {
    private int divider;

    public MyPaddingDecoration() {
        divider = 10;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);
        if (parent.getAdapter().getItemViewType(position)==0) {
            outRect.left = divider;
            outRect.top = divider;
            outRect.right = divider;
            outRect.bottom = divider;
        } else {
            outRect.bottom = divider;
            outRect.top = divider;
        }
    }

}