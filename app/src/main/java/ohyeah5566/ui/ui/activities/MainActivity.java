package ohyeah5566.ui.ui.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.fragment.HomeFragment;
import ohyeah5566.ui.ui.fragment.MemberFragment;
import ohyeah5566.ui.ui.fragment.NewsFragment;
import ohyeah5566.ui.ui.fragment.NotifyFragment;
import ohyeah5566.ui.ui.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";
    @BindView(R.id.parent_home) LinearLayout parentHome;
    @BindView(R.id.parent_news) LinearLayout parentNews;
    @BindView(R.id.parent_shopping) LinearLayout parentShopping;
    @BindView(R.id.parent_notification) LinearLayout parentNotification;
    @BindView(R.id.parent_member) LinearLayout parentMember;
    private HomeFragment homeFragment;
    private NewsFragment newsFragment;
    private ShopFragment shoppingFragment;
    private NotifyFragment notifyFragment;
    private MemberFragment memberFragment;

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();

    }


    @OnClick({R.id.parent_home, R.id.parent_news, R.id.parent_shopping, R.id.parent_notification, R.id.parent_member})
    public void onViewClicked(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (view.getId()) {
            case R.id.parent_home:
                Log.d(TAG, "press Home");
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.frame_main, homeFragment);
                }
                break;
            case R.id.parent_news:
                Log.d(TAG, "press news");
                if (newsFragment == null) {
                    newsFragment = new NewsFragment();
                    fragmentTransaction.add(R.id.frame_main, newsFragment);
                }
                break;
            case R.id.parent_shopping:
                Log.d(TAG, "press shopping");
                if (shoppingFragment == null) {
                    shoppingFragment = new ShopFragment();
                    fragmentTransaction.add(R.id.frame_main, shoppingFragment);
                }
                break;
            case R.id.parent_notification:
                Log.d(TAG, "press notification");
                if (notifyFragment == null) {
                    notifyFragment = new NotifyFragment();
                    fragmentTransaction.add(R.id.frame_main, notifyFragment);
                }
                break;
            case R.id.parent_member:
                Log.d(TAG, "press member");
                if (memberFragment == null) {
                    memberFragment = new MemberFragment();
                    fragmentTransaction.add(R.id.frame_main, memberFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }
}
