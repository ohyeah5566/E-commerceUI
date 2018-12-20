package ohyeah5566.ui.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ohyeah5566.ui.R;

/**
 * Created by yiwei on 2018/12/20.
 */
public class DividerDecoration extends RecyclerView.ItemDecoration {

    int lineHeight = 2;
    Context context;

    public DividerDecoration(Context context){
        this.context = context;
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();

        for (int i = 1; i < parent.getChildCount(); i++) {
            View view = parent.getChildAt(i);
            int top = view.getTop();
            int bottom = view.getBottom();
            Paint paint = new Paint();
            paint.setColor(ContextCompat.getColor(context,R.color.divider));
            c.drawRect(left, top, right, top + lineHeight,paint);
        }


    }
}
