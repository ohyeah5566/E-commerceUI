package ohyeah5566.ui.ui;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ohyeah5566.ui.R;

/**
 * Created by yiwei on 2018/11/28.
 */
public class RecycleviewAdapater extends RecyclerView.Adapter<RecycleviewAdapater.ViewHolder> {

    private List<Product> dataLists;
    private Context mContext;
    private View header;
    private View loadmoreview;
    int TYPE_NORMAL = 0;
    int TYPE_HEADER = 1;
    int TYPE_FOOTER = 2;

    public RecycleviewAdapater(List<Product> data, Context mContext) {
        dataLists = data;
        this.mContext = mContext;
    }

    public void setHeaderView(View headerView) {
        header = headerView;
        notifyItemInserted(0);
    }

    public void setFooterView(View footerView) {
        loadmoreview = footerView;
        notifyItemInserted(getItemCount() - 1);
    }

    public void addData(List<Product> data){
        dataLists.addAll(data);
        notifyItemInserted(getItemCount() - 1);  //最後的位置留給Footer
    }

    @Override
    public int getItemViewType(int position) {
        if (header == null && loadmoreview == null) {
            return TYPE_NORMAL;
        }
        if (position == 0) return TYPE_HEADER;
        if (position == getItemCount() - 1) return TYPE_FOOTER;
        return TYPE_NORMAL;
    }

    //重写此方法，判断recyclerview的layoutmanager为StaggeredGridLayoutManager的时候，是header和footer独占一行，而不是一个item
    @Override
    public void onViewAttachedToWindow(ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            params.setFullSpan(getItemViewType(holder.getLayoutPosition()) == TYPE_HEADER
                    || getItemViewType(holder.getLayoutPosition()) == TYPE_FOOTER);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (header != null && viewType == TYPE_HEADER) return new ViewHolder(header);
        if (loadmoreview != null && viewType == TYPE_FOOTER) return new ViewHolder(loadmoreview);
        View view = View.inflate(parent.getContext(), R.layout.item_productcard, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_NORMAL) {
            holder.imgv_ItemcardImg.setImageDrawable(ContextCompat.getDrawable(mContext, dataLists.get(position - 1).getImageID()));
            holder.tv_ItemcardTitle.setText(dataLists.get(position - 1).getName());
            holder.tv_ItemcardPrice.setText(dataLists.get(position - 1).getOriginPrice());
            holder.tv_ItemcardSpecPrice.setText(dataLists.get(position - 1).getSpecPrice());
        } else
            return;
    }

    @Override
    public int getItemCount() {
        if (header == null && loadmoreview == null)
            return dataLists.size();
        else if (header != null && loadmoreview != null)
            return dataLists.size() + 2;
        else
            return dataLists.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgv_itemcard_img) ImageView imgv_ItemcardImg;
        @BindView(R.id.tv_itemcard_title) TextView tv_ItemcardTitle;
        @BindView(R.id.tv_itemcard_price) TextView tv_ItemcardPrice;
        @BindView(R.id.tv_itemcard_specPrice) TextView tv_ItemcardSpecPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            if (itemView != header && itemView != loadmoreview) {
                ButterKnife.bind(this, itemView);
            }
        }
    }

}
