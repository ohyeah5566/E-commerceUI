package ohyeah5566.ui.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.Product;

/**
 * Created by yiwei on 2018/12/5.
 */
public class ItemTitleDecoration extends RecyclerView.ItemDecoration {
    private Context mContext;
    private List<Product> mList;
    private LayoutInflater mLayoutInflater;

    View topTitleView;


    public ItemTitleDecoration(Context context, List<Product> dataList) {
        super();
        this.mContext = context;
        this.mList = dataList;
        this.mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        int position = ((GridLayoutManager) parent.getLayoutManager()).findFirstVisibleItemPosition();
        if (position == 0) return; // position=0=header view

        if (mList.get(position - 1).isTitle()) {
            topTitleView = mLayoutInflater.inflate(R.layout.item_title, parent, false);
            TextView textView = (TextView) topTitleView.findViewById(R.id.tv_itemTitle);
            textView.setText(mList.get(position - 1).getTitle());
        }
        drawHeader(parent,c);
    }

    private void drawHeader(RecyclerView parent, Canvas c) {

        RecyclerView.LayoutParams lp = (RecyclerView.LayoutParams) topTitleView.getLayoutParams();
        if (lp == null) {
            lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);//这里是根据复杂布局layout的width height，new一个Lp
            topTitleView.setLayoutParams(lp);
        }
        topTitleView.setLayoutParams(lp);

        int toDrawWidthSpec = View.MeasureSpec.makeMeasureSpec(parent.getWidth() - parent.getPaddingLeft() - parent.getPaddingRight(), View.MeasureSpec.EXACTLY);
        int toDrawHeightSpec = View.MeasureSpec.makeMeasureSpec(parent.getHeight() - parent.getPaddingTop() - parent.getPaddingBottom(), View.MeasureSpec.AT_MOST);

        topTitleView.measure(toDrawWidthSpec, toDrawHeightSpec);
        topTitleView.layout(parent.getPaddingLeft(), parent.getPaddingTop(), parent.getPaddingLeft() + topTitleView.getMeasuredWidth(), parent.getPaddingTop() + topTitleView.getMeasuredHeight());
        topTitleView.draw(c);
    }


}
