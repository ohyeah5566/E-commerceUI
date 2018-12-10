package ohyeah5566.ui.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.HotsaleAdapter;
import ohyeah5566.ui.ui.HotsaleItem;
import ohyeah5566.ui.ui.ItemTitleDecoration;
import ohyeah5566.ui.ui.MyPaddingDecoration;
import ohyeah5566.ui.ui.Product;
import ohyeah5566.ui.ui.RecycleviewAdapater;
import ohyeah5566.ui.ui.homeImageloader;

/**
 * Created by yiwei on 2018/11/23.
 */
public class HomeFragment extends Fragment {
    String TAG = "HomeFragment";

    @BindView(R.id.home_recycleview) RecyclerView mRecycleView;

    RecycleviewAdapater recycleviewAdapater;
    private List<Product> productList = new ArrayList<>();
    View header;
    View footer;
    Banner banner;
    boolean loading = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);


        iniRecyclerview();
        iniHeader();
        addFooter();
        iniBanner();
        recycleviewAdapater.setHeaderView(header);
        recycleviewAdapater.setFooterView(footer);

        Log.d("HomeFragment", "onCreateView");

        return rootView;
    }

    private void iniRecyclerview() {

        productList.clear();
        productList.add(new Product("每日新發現"));
        productList.add(new Product(R.drawable.commodity_1, "金牌干溜 1984酸辣粉 257g", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_2, "【Alice書店】修煉（全套4冊）／青少年奇幻小說／陳郁如／全新／小兵出版", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_3, "當天出貨 [ 附發票 ] 新小米行動電源2 10000mAh 雙向USB接口 雙向快充 行動電源", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_4, "3C買賣 SONY PlayStation SCPH-7501 遊戲主機", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_5, "[貓貓蟲-咖波] 經典造型 絨毛娃娃", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_6, "手機電視棒-支援IOS12 電視棒 M5 手機電視同屏顯示 手機連電視 HDMI AnycastPlus", "$120", "$95"));
        recycleviewAdapater = new RecycleviewAdapater(productList, getContext());
        mRecycleView.setAdapter(recycleviewAdapater);
        mRecycleView.addItemDecoration(new MyPaddingDecoration());
        mRecycleView.addItemDecoration(new ItemTitleDecoration(getContext(), productList));
        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!loading && !recyclerView.canScrollVertically(1)) { //canScrollVertically能否往下滑動
                    Log.d(TAG, "到底惹");
                    loading = true;

                    try {
                        Thread.sleep(500);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    productList.add(new Product(R.drawable.commodity_1, "金牌干溜 1984酸辣粉 257g", "$120", "$95"));
                    productList.add(new Product(R.drawable.commodity_2, "【Alice書店】修煉（全套4冊）／青少年奇幻小說／陳郁如／全新／小兵出版", "$120", "$95"));
                    productList.add(new Product(R.drawable.commodity_3, "當天出貨 [ 附發票 ] 新小米行動電源2 10000mAh 雙向USB接口 雙向快充 行動電源", "$120", "$95"));
                    productList.add(new Product(R.drawable.commodity_4, "3C買賣 SONY PlayStation SCPH-7501 遊戲主機", "$120", "$95"));
                    productList.add(new Product(R.drawable.commodity_5, "[貓貓蟲-咖波] 經典造型 絨毛娃娃", "$120", "$95"));
                    productList.add(new Product(R.drawable.commodity_6, "手機電視棒-支援IOS12 電視棒 M5 手機電視同屏顯示 手機連電視 HDMI AnycastPlus", "$120", "$95"));
                    recycleviewAdapater.addData(productList);
                    loading = false;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                mRecycleView.getLayoutManager().getChildCount();
            }
        });

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (recycleviewAdapater.getItemViewType(position)) {
                    case 0: //Item 1格
                        return 1;
                    default:  //Titel, header, footer 佔兩格
                        return 2;
                }
            }
        });
        mRecycleView.setLayoutManager(gridLayoutManager);

    }


    private void iniHeader() {
        List<HotsaleItem> mList = new ArrayList<>();
        mList.add(new HotsaleItem(R.drawable.hotitem_1, "Adidas 帽子", "$" + 280, "$" + 300));
        mList.add(new HotsaleItem(R.drawable.hotitem_2, "Adidas 鞋子", "$" + 2300, "$" + 3000));
        mList.add(new HotsaleItem(R.drawable.hotitem_3, "發熱衣", "$" + 120, "$" + 140));
        mList.add(new HotsaleItem(R.drawable.hotitem_4, "木製櫃", "$" + 3300, "$" + 4500));
        mList.add(new HotsaleItem(R.drawable.hotitem_5, "充電線", "$" + 80, "$" + 150));
        mList.add(new HotsaleItem(R.drawable.hotitem_6, "鍋子", "$" + 800, "$" + 980));
        mList.add(new HotsaleItem(R.drawable.hotitem_7, "洗衣精", "$" + 230, "$" + 250));
        mList.add(new HotsaleItem(R.drawable.hotitem_8, "電熱毯", "$" + 13000, "$" + 14500));

        header = LayoutInflater.from(getContext()).inflate(R.layout.header_home, mRecycleView, false);
        ImageView imageView = header.findViewById(R.id.imgv_category);
        Glide.with(getContext()).load(ContextCompat.getDrawable(getContext(), R.drawable.category))
                .into(imageView);

        RecyclerView Rview = header.findViewById(R.id.header_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        Rview.setLayoutManager(manager);
        Rview.setAdapter(new HotsaleAdapter(mList, getContext()));
        Rview.setNestedScrollingEnabled(false);

    }

    private void addFooter() {
        footer = LayoutInflater.from(getContext()).inflate(R.layout.footer, mRecycleView, false);
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
