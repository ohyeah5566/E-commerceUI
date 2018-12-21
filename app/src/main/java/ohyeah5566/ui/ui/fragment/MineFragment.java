package ohyeah5566.ui.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ohyeah5566.ui.R;

/**
 * Created by yiwei on 2018/11/23.
 */
public class MineFragment extends Fragment {
    @BindView(R.id.imgv_profilebackground) ImageView imgv_Profilebackground;
    @BindView(R.id.btn_mine_buying) Button btnMineBuying;
    @BindView(R.id.btn_mine_selling) Button btnMineSelling;

    private FragmentManager fragmentManager;
    private BuyingFragment buyingFragment;
    private SellingFragment sellingFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getFragmentManager();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_me, container, false);
        ButterKnife.bind(this, rootView);
        Glide.with(getContext()).load(R.drawable.profile_background).apply(new RequestOptions().centerCrop()).into(imgv_Profilebackground);

        onViewClicked(btnMineBuying);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.btn_mine_buying, R.id.btn_mine_selling})
    public void onViewClicked(View view) {
        iniBtnBackGround();
        iniFragment();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.btn_mine_buying:
                btnMineBuying.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.mine_btn_selected));
                if (buyingFragment == null) {
                    buyingFragment = new BuyingFragment();
                    fragmentTransaction.add(R.id.fl_mine_framelayout, buyingFragment);
                } else
                    fragmentTransaction.show(buyingFragment);
                break;
            case R.id.btn_mine_selling:
                btnMineSelling.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.mine_btn_selected));
                if (sellingFragment == null) {
                    sellingFragment = new SellingFragment();
                    fragmentTransaction.add(R.id.fl_mine_framelayout, sellingFragment);
                } else
                    fragmentTransaction.show(sellingFragment);
                break;
        }

        fragmentTransaction.commit();
    }

    private void iniBtnBackGround() {
        btnMineSelling.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.mine_btn_selector));
        btnMineBuying.setBackground(ContextCompat.getDrawable(getContext(), R.drawable.mine_btn_selector));
    }

    private void iniFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (buyingFragment != null) fragmentTransaction.hide(buyingFragment);
        if (sellingFragment != null) fragmentTransaction.hide(sellingFragment);
        fragmentTransaction.commit();
    }
}
