package ohyeah5566.ui.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import ohyeah5566.ui.ui.DataCenter;
import ohyeah5566.ui.ui.HotsaleAdapter;
import ohyeah5566.ui.ui.HotsaleProduct;
import ohyeah5566.ui.ui.ItemTitleDecoration;
import ohyeah5566.ui.ui.HomePaddingDecoration;
import ohyeah5566.ui.ui.LoadingDoneCallbacks;
import ohyeah5566.ui.ui.Product;
import ohyeah5566.ui.ui.HomeRecycleviewAdapater;
import ohyeah5566.ui.ui.HomeImageloader;

/**
 * Created by yiwei on 2018/11/23.
 */
public class HomeFragment extends Fragment implements LoadingDoneCallbacks {
    String TAG = "HomeFragment";

    @BindView(R.id.home_recycleview) RecyclerView mRecycleView;

    HomeRecycleviewAdapater homeRecycleviewAdapater;
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
        homeRecycleviewAdapater.setHeaderView(header);
        homeRecycleviewAdapater.setFooterView(footer);

        Log.d("HomeFragment", "onCreateView");

        return rootView;
    }

    private void iniRecyclerview() {
        List<Product> productList = DataCenter.getProductList();
        homeRecycleviewAdapater = new HomeRecycleviewAdapater(productList, getContext());
        mRecycleView.setAdapter(homeRecycleviewAdapater);
        mRecycleView.addItemDecoration(new HomePaddingDecoration());
        mRecycleView.addItemDecoration(new ItemTitleDecoration(getContext(), productList));
        mRecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!loading && !recyclerView.canScrollVertically(1)) { //canScrollVertically能否往下滑動
                    Log.d(TAG, "到底惹");
                    loading = true;
                    loadNewData();
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
                switch (homeRecycleviewAdapater.getItemViewType(position)) {
                    case 0: //Item 1格
                        return 1;
                    default:  //Titel, header, footer_home 佔兩格
                        return 2;
                }
            }
        });
        mRecycleView.setLayoutManager(gridLayoutManager);

    }

    private void loadNewData() {
        DataCenter.loadMoreData(getActivity(), homeRecycleviewAdapater,this);
    }


    private void iniHeader() {
        List<HotsaleProduct> mList = DataCenter.getHotSaleProductList();
        header = LayoutInflater.from(getContext()).inflate(R.layout.header_home, mRecycleView, false);
        ImageView imageView = header.findViewById(R.id.imgv_category);
        Glide.with(getContext()).load(R.drawable.category).into(imageView);

        RecyclerView Rview = header.findViewById(R.id.header_recycleview);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        Rview.setLayoutManager(manager);
        Rview.setAdapter(new HotsaleAdapter(mList, getContext()));
        Rview.setNestedScrollingEnabled(false);
    }

    private void addFooter() {
        footer = LayoutInflater.from(getContext()).inflate(R.layout.footer_home, mRecycleView, false);
    }

    private void iniBanner() {
        banner = header.findViewById(R.id.home_banner);
        List<Integer> list_image = new ArrayList<>();
        list_image.add(R.drawable.banner_1);
        list_image.add(R.drawable.banner_2);
        list_image.add(R.drawable.banner_3);
        list_image.add(R.drawable.banner_4);

        banner.setImageLoader(new HomeImageloader());
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

    @Override
    public void LoadingDone() {
        loading = false;
    }
}
