package ohyeah5566.ui.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.HotsaleAdapter;
import ohyeah5566.ui.ui.HotsaleItem;
import ohyeah5566.ui.ui.Product;
import ohyeah5566.ui.ui.RecycleviewAdapater;
import ohyeah5566.ui.ui.homeImageloader;

/**
 * Created by yiwei on 2018/11/23.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.home_recycleview) RecyclerView mRecycleView;

    private List<Product> productList= new ArrayList<>();
    View header ;
    Banner banner;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        productList.add(new Product(R.drawable.commodity_1,"金牌干溜 1984酸辣粉 257g","$120","$95"));
        productList.add(new Product(R.drawable.commodity_2,"金牌干溜 1984酸辣粉 257g","$120","$95"));
        productList.add(new Product(R.drawable.commodity_3,"金牌干溜 1984酸辣粉 257g","$120","$95"));
        productList.add(new Product(R.drawable.commodity_4,"金牌干溜 1984酸辣粉 257g","$120","$95"));
        productList.add(new Product(R.drawable.commodity_5,"金牌干溜 1984酸辣粉 257g","$120","$95"));
        productList.add(new Product(R.drawable.commodity_6,"金牌干溜 1984酸辣粉 257g","$120","$95"));
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleviewAdapater recycleviewAdapater = new RecycleviewAdapater(productList,getContext());
        mRecycleView.setAdapter(recycleviewAdapater);
        mRecycleView.setLayoutManager(new
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        iniHeader();
        iniBanner();
        recycleviewAdapater.setHeaderView(header);

        return rootView;
    }


    private void iniHeader() {
        List<HotsaleItem> mList = new ArrayList<>();
        mList.add(new HotsaleItem(R.drawable.hotitem_1, "Adidas 帽子", "$"+280, "$"+300));
        mList.add(new HotsaleItem(R.drawable.hotitem_2, "Adidas 鞋子", "$"+2300, "$"+3000));
        mList.add(new HotsaleItem(R.drawable.hotitem_3, "發熱衣", "$"+120, "$"+140));
        mList.add(new HotsaleItem(R.drawable.hotitem_4, "木製櫃", "$"+3300, "$"+4500));
        mList.add(new HotsaleItem(R.drawable.hotitem_5, "充電線", "$"+80, "$"+150));
        mList.add(new HotsaleItem(R.drawable.hotitem_6, "鍋子", "$"+800, "$"+980));
        mList.add(new HotsaleItem(R.drawable.hotitem_7, "洗衣精", "$"+230, "$"+250));
        mList.add(new HotsaleItem(R.drawable.hotitem_8, "電熱毯", "$"+13000, "$"+14500));

        header = LayoutInflater.from(getContext()).inflate(R.layout.header_home,mRecycleView,false);
        RecyclerView Rview = header.findViewById(R.id.header_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        Rview.setLayoutManager(manager);
        Rview.setAdapter(new HotsaleAdapter(mList,getContext()));
        Rview.setNestedScrollingEnabled(false);

    }

    private void iniBanner() {
        banner = header.findViewById(R.id.home_banner);
        List<Drawable> list_image = new ArrayList<>();
        list_image.add(ContextCompat.getDrawable(getContext(), R.drawable.banner_1));
        list_image.add(ContextCompat.getDrawable(getContext(), R.drawable.banner_2));
        list_image.add(ContextCompat.getDrawable(getContext(), R.drawable.banner_3));
        list_image.add(ContextCompat.getDrawable(getContext(), R.drawable.banner_4));

        banner.setImageLoader(new homeImageloader());
        //设置图片集合
        banner.setImages(list_image);
        //banner设置方法全部调用完毕时最后调用
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        banner.start();
    }


    @Override
    public void onStart() {
        super.onStart();

        banner.startAutoPlay();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
