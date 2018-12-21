package ohyeah5566.ui.ui;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
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
public class HotsaleAdapter extends RecyclerView.Adapter<HotsaleAdapter.ViewHolder> {

    private List<HotsaleProduct> mList;
    private Context mContext;

    public HotsaleAdapter(List<HotsaleProduct> list, Context context) {
        mList = list;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_hotsale, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).load(mList.get(position).getImageID()).into(holder.imgv_CategoryCommodity);
        holder.tv_CategoryCommodityName.setText(mList.get(position).getCommodityName());
        holder.tv_CategoryCommodityPrice.setText(mList.get(position).getPrice());
        holder.tv_CategoryCommodityPriceOrigin.setText(mList.get(position).getPriceOrigin());
        holder.tv_CategoryCommodityPriceOrigin.setPaintFlags(
                holder.tv_CategoryCommodityPriceOrigin.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imgv_category_commodity) ImageView imgv_CategoryCommodity;
        @BindView(R.id.tv_category_commodityName) TextView tv_CategoryCommodityName;
        @BindView(R.id.tv_category_commodity_price) TextView tv_CategoryCommodityPrice;
        @BindView(R.id.tv_category_commodity_priceOrigin) TextView tv_CategoryCommodityPriceOrigin;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
