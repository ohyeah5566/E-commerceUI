package ohyeah5566.ui.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.DividerDecoration;
import ohyeah5566.ui.ui.MemberRecyclerViewAdapter;
import ohyeah5566.ui.ui.MemberRecyclerViewItem;

/**
 * Created by yiwei on 2018/12/18.
 */
public class BuyingFragment extends Fragment {
    @BindView(R.id.recyclerview_item) RecyclerView recyclerviewItem;
    List<MemberRecyclerViewItem> list = new ArrayList<>();
    MemberRecyclerViewAdapter memberRecyclerViewAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_buying, container, false);
        ButterKnife.bind(this, rootView);
        iniRecyclerView();
        return rootView;
    }

    private void iniRecyclerView(){
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconlike,"按讚好物","查看按讚好物"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconbuytogether,"我的團購","查看團購"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconrecord,"瀏覽紀錄","近期查看"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconmoneypack,"邀請我的朋友","邀請朋友賺蝦幣"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconshopbee,"我的蝦皮錢包","查看我的錢包"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconinvite,"我的蝦幣","100 蝦幣"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconrating,"我的評價","查看我的評價"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconcoupon,"我的優惠券","查看我的優惠券"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconaccount,"我的帳戶","查看我的帳戶"));
        list.add(new MemberRecyclerViewItem(R.drawable.mine_iconhelp,"幫助中心","查看幫助中心"));
        memberRecyclerViewAdapter = new MemberRecyclerViewAdapter(list,getContext());
        recyclerviewItem.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerviewItem.setAdapter(memberRecyclerViewAdapter);
        recyclerviewItem.addItemDecoration(new DividerDecoration(getContext()));
    }

}
