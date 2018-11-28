package ohyeah5566.ui.ui.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.homeImageloader;

/**
 * Created by yiwei on 2018/11/23.
 */
public class HomeFragment extends Fragment {


    @BindView(R.id.home_banner) Banner banner;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);
        List<Drawable> list_image = new ArrayList<>();
        list_image.add(ContextCompat.getDrawable(getContext(),R.drawable.banner_1));
        list_image.add(ContextCompat.getDrawable(getContext(),R.drawable.banner_2));
        list_image.add(ContextCompat.getDrawable(getContext(),R.drawable.banner_3));
        list_image.add(ContextCompat.getDrawable(getContext(),R.drawable.banner_4));

        banner.setImageLoader(new homeImageloader());
        //设置图片集合
        banner.setImages(list_image);
        //banner设置方法全部调用完毕时最后调用
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        banner.start();
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        banner.startAutoPlay();
    }
}
