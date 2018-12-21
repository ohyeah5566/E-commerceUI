package ohyeah5566.ui.ui.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.fragment.HomeFragment;
import ohyeah5566.ui.ui.fragment.MineFragment;
import ohyeah5566.ui.ui.fragment.NewsFragment;
import ohyeah5566.ui.ui.fragment.NotifyFragment;
import ohyeah5566.ui.ui.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    @BindView(R.id.parent_home) LinearLayout parentHome;
    @BindView(R.id.parent_news) LinearLayout parentNews;
    @BindView(R.id.parent_shopping) LinearLayout parentShopping;
    @BindView(R.id.parent_notification) ConstraintLayout parentNotification;
    @BindView(R.id.parent_member) LinearLayout parentMember;
    @BindView(R.id.imgv_home) ImageView imgv_Home;
    @BindView(R.id.imgv_news) ImageView imgv_News;
    @BindView(R.id.imgv_shopping) ImageView imgv_Shopping;
    @BindView(R.id.imgv_notification) ImageView imgv_Notification;
    @BindView(R.id.imgv_member) ImageView imgv_Member;
    @BindView(R.id.tv_home) TextView tv_Home;
    @BindView(R.id.tv_news) TextView tv_News;
    @BindView(R.id.tv_shopping) TextView tv_Shopping;
    @BindView(R.id.tv_notification) TextView tv_Notification;
    @BindView(R.id.tv_member) TextView tv_Member;
    private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private ShopFragment shoppingFragment;
    private NotifyFragment notifyFragment;
    private MineFragment mineFragment;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        iniBtnColor();
        fragmentManager = getSupportFragmentManager();
    }


    @OnClick({R.id.parent_home, R.id.parent_news, R.id.parent_shopping, R.id.parent_notification, R.id.parent_member})
    public void onViewClicked(View view) {
        iniBtnColor();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        switch (view.getId()) {
            case R.id.parent_home:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.frame_main, homeFragment);
                }
                fragmentTransaction.show(homeFragment);

                Glide.with(this).load(R.drawable.ic_home_press).into(imgv_Home);
                tv_Home.setTextColor(ContextCompat.getColor(this, R.color.colorHomeTextPress));
                break;
            case R.id.parent_news:
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    fragmentTransaction.add(R.id.frame_main, newsFragment);
                }
                fragmentTransaction.show(newsFragment);

                Glide.with(this).load( R.drawable.ic_news_press).into(imgv_News);
                tv_News.setTextColor(ContextCompat.getColor(this, R.color.colorHomeTextPress));
                break;
            case R.id.parent_shopping:
                if (shoppingFragment == null) {
                    shoppingFragment = new ShopFragment();
                    fragmentTransaction.add(R.id.frame_main, shoppingFragment);
                }
                fragmentTransaction.show(shoppingFragment);

                Glide.with(this).load( R.drawable.ic_shopping_press)
                        .into(imgv_Shopping);
                tv_Shopping.setTextColor(ContextCompat.getColor(this, R.color.colorHomeTextPress));
                break;
            case R.id.parent_notification:
                if (notifyFragment == null) {
                    notifyFragment = new NotifyFragment();
                    fragmentTransaction.add(R.id.frame_main, notifyFragment);
                }
                fragmentTransaction.show(notifyFragment);

                Glide.with(this).load(R.drawable.ic_notify_press).into(imgv_Notification);
                tv_Notification.setTextColor(ContextCompat.getColor(this, R.color.colorHomeTextPress));
                break;
            case R.id.parent_member:
                if (mineFragment == null) {
                    mineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.frame_main, mineFragment);
                }
                fragmentTransaction.show(mineFragment);

                Glide.with(this).load( R.drawable.ic_member_press).into(imgv_Member);
                tv_Member.setTextColor(ContextCompat.getColor(this, R.color.colorHomeTextPress));
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (homeFragment != null)
            fragmentTransaction.hide(homeFragment);
        if (newsFragment != null)
            fragmentTransaction.hide(newsFragment);
        if (shoppingFragment != null)
            fragmentTransaction.hide(shoppingFragment);
        if (notifyFragment != null)
            fragmentTransaction.hide(notifyFragment);
        if (mineFragment != null)
            fragmentTransaction.hide(mineFragment);
    }

    private void iniBtnColor() {
        tv_Home.setTextColor(ContextCompat.getColor(this, R.color.colorTextDefault));
        tv_News.setTextColor(ContextCompat.getColor(this, R.color.colorTextDefault));
        tv_Shopping.setTextColor(ContextCompat.getColor(this, R.color.colorTextDefault));
        tv_Notification.setTextColor(ContextCompat.getColor(this, R.color.colorTextDefault));
        tv_Member.setTextColor(ContextCompat.getColor(this, R.color.colorTextDefault));

        imgv_Home.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_home));
        imgv_News.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_news));
        imgv_Shopping.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_shopping));
        imgv_Notification.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_notify));
        imgv_Member.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_member));

    }
}
