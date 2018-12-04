package ohyeah5566.ui.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ohyeah5566.ui.R;

/**
 * Created by yiwei on 2018/11/28.
 */
public class RecycleviewAdapater extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Product> dataLists;
    private Context mContext;
    private View header;
    private View loadmoreview;
    int TYPE_NORMAL = 0;
    int TYPE_HEADER = 1;
    int TYPE_FOOTER = 2;
    int TYPE_TITLE = 3;

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

    public void addData(List<Product> data) {
        dataLists.addAll(data);
        notifyItemInserted(getItemCount() - 1);  //最後的位置留給Footer
    }

    @Override
    public int getItemViewType(int position) {
        if (header == null && loadmoreview == null) {
            return dataLists.get(position).isTitle() ? TYPE_TITLE : TYPE_NORMAL;
        }
        if (position == 0) return TYPE_HEADER;
        if (position == getItemCount() - 1) return TYPE_FOOTER;

        return dataLists.get(position - 1).isTitle() ? TYPE_TITLE : TYPE_NORMAL;
    }

    //重写此方法，判断recyclerview的layoutmanager为StaggeredGridLayoutManager的时候，是header和footer独占一行，而不是一个item
    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null && layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            params.setFullSpan(getItemViewType(holder.getLayoutPosition()) == TYPE_HEADER
                    || getItemViewType(holder.getLayoutPosition()) == TYPE_FOOTER
                    || getItemViewType(holder.getLayoutPosition()) == TYPE_TITLE);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (header != null && viewType == TYPE_HEADER) return new ViewHolder(header);
        if (loadmoreview != null && viewType == TYPE_FOOTER) return new ViewHolder(loadmoreview);
        if (viewType == TYPE_TITLE) {
            View view = View.inflate(parent.getContext(), R.layout.item_title, null);
            return new TitleHolder(view);
        }
        View view = View.inflate(parent.getContext(), R.layout.item_productcard, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (getItemViewType(position) == TYPE_NORMAL) {
            ViewHolder viewHolder = (ViewHolder) holder;
            Glide.with(mContext).load(ContextCompat.getDrawable(mContext, dataLists.get(position - 1).getImageID()))
                    .into(viewHolder.imgv_ItemcardImg);
            //  holder.imgv_ItemcardImg.setImageDrawable(ContextCompat.getDrawable(mContext, dataLists.get(position - 1).getImageID()));
            viewHolder.tv_ItemcardTitle.setText(dataLists.get(position - 1).getName());
            viewHolder.tv_ItemcardPrice.setText(dataLists.get(position - 1).getOriginPrice());
            viewHolder.tv_ItemcardSpecPrice.setText(dataLists.get(position - 1).getSpecPrice());
        } else if (getItemViewType(position) == TYPE_TITLE) {
            TitleHolder viewHolder = (TitleHolder) holder;
            viewHolder.tv_itemTitle.setText(dataLists.get(position - 1).getTitle());
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

    public class TitleHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_itemTitle) TextView tv_itemTitle;

        public TitleHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
