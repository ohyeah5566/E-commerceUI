package ohyeah5566.ui.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import ohyeah5566.ui.ui.RecycleviewAdapater;
import ohyeah5566.ui.ui.homeImageloader;

/**
 * Created by yiwei on 2018/11/23.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.home_recycleview) RecyclerView mRecycleView;

    private List<String> stringList= new ArrayList<>();
    View header ;
    Banner banner;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);


        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        stringList.add("4");
        mRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycleviewAdapater recycleviewAdapater = new RecycleviewAdapater(stringList);
        mRecycleView.setAdapter(recycleviewAdapater);

        iniHeader();
        iniBanner();
        recycleviewAdapater.setHeaderView(header);

        return rootView;
    }


    private void iniHeader() {
        List<HotsaleItem> mList = new ArrayList<>();
        mList.add(new HotsaleItem(R.drawable.hotitem_1, "【天然健康膳\n食狗粮，提升...", 39.9+"", 9+""));
        mList.add(new HotsaleItem(R.drawable.hotitem_2, "【适合搭配\n各类猫砂使用...", 29+"", 62+""));
        mList.add(new HotsaleItem(R.drawable.hotitem_3, "【温和配方,\n消炎止痒，抗...", 25+"", 40+""));
        mList.add(new HotsaleItem(R.drawable.hotitem_4, "【精致牛肉肉\n粒，美味有营...", 9.9+"", 35+""));

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
