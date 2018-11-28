package ohyeah5566.ui.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ohyeah5566.ui.R;

/**
 * Created by yiwei on 2018/11/28.
 */
public class RecycleviewAdapater extends RecyclerView.Adapter<RecycleviewAdapater.ViewHolder> {

    private List<String> dataLists;
    private View header;
    int TYPE_NORMAL = 0;
    int TYPE_HEADER = 1;

    public RecycleviewAdapater(List<String> data) {
        dataLists = data;
    }

    public void setHeaderView(View headerView) {
        header = headerView;
        notifyItemInserted(0);
    }

    public View getHeaderView() {
        return header;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (header != null && viewType == TYPE_HEADER) return new ViewHolder(header);

        View view = View.inflate(parent.getContext(), R.layout.item_recycleview, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (getItemViewType(position) == TYPE_NORMAL)
            holder.mTextView.setText(dataLists.get(position - 1));
        else
            return;
    }

    @Override
    public int getItemCount() {
        if (header == null)
            return dataLists.size();
        else
            return dataLists.size() + 1;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            if (itemView != header)
                mTextView = (TextView) itemView.findViewById(R.id.recycle_textview);
        }
    }

}
