package ohyeah5566.ui.ui;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;

import ohyeah5566.ui.R;
import ohyeah5566.ui.ui.fragment.HomeFragment;

/**
 * Created by yiwei on 2018/12/21.
 */
public class DataCenter {

    public static List<Product> getProductList() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("每日新發現"));
        productList.add(new Product(R.drawable.commodity_1, "金牌干溜 1984酸辣粉 257g", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_2, "【Alice書店】修煉（全套4冊）／青少年奇幻小說／陳郁如／全新／小兵出版", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_3, "當天出貨 [ 附發票 ] 新小米行動電源2 10000mAh 雙向USB接口 雙向快充 行動電源", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_4, "3C買賣 SONY PlayStation SCPH-7501 遊戲主機", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_5, "[貓貓蟲-咖波] 經典造型 絨毛娃娃", "$120", "$95"));
        productList.add(new Product(R.drawable.commodity_6, "手機電視棒-支援IOS12 電視棒 M5 手機電視同屏顯示 手機連電視 HDMI AnycastPlus", "$120", "$95"));
        return productList;
    }


    public static List<HotsaleProduct> getHotSaleProductList() {
        List<HotsaleProduct> list = new ArrayList<>();
        list.add(new HotsaleProduct(R.drawable.hotitem_1, "Adidas 帽子", "$" + 280, "$" + 300));
        list.add(new HotsaleProduct(R.drawable.hotitem_2, "Adidas 鞋子", "$" + 2300, "$" + 3000));
        list.add(new HotsaleProduct(R.drawable.hotitem_3, "發熱衣", "$" + 120, "$" + 140));
        list.add(new HotsaleProduct(R.drawable.hotitem_4, "木製櫃", "$" + 3300, "$" + 4500));
        list.add(new HotsaleProduct(R.drawable.hotitem_5, "充電線", "$" + 80, "$" + 150));
        list.add(new HotsaleProduct(R.drawable.hotitem_6, "鍋子", "$" + 800, "$" + 980));
        list.add(new HotsaleProduct(R.drawable.hotitem_7, "洗衣精", "$" + 230, "$" + 250));
        list.add(new HotsaleProduct(R.drawable.hotitem_8, "電熱毯", "$" + 13000, "$" + 14500));
        return list;
    }

    public static void loadMoreData(final FragmentActivity activity, final HomeRecycleviewAdapater homeRecycleviewAdapater, HomeFragment homeFragment) {

        final LoadingDoneCallbacks finalLoadingDoneCallbacks = (LoadingDoneCallbacks) homeFragment ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try { //延遲0.5秒 製造有在讀取的樣子
                    Thread.sleep(500);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        homeRecycleviewAdapater.addData(new Product(R.drawable.commodity_1, "金牌干溜 1984酸辣粉 257g", "$120", "$95"));
                        homeRecycleviewAdapater.addData(new Product(R.drawable.commodity_2, "【Alice書店】修煉（全套4冊）／青少年奇幻小說／陳郁如／全新／小兵出版", "$120", "$95"));
                        homeRecycleviewAdapater.addData(new Product(R.drawable.commodity_3, "當天出貨 [ 附發票 ] 新小米行動電源2 10000mAh 雙向USB接口 雙向快充 行動電源", "$120", "$95"));
                        homeRecycleviewAdapater.addData(new Product(R.drawable.commodity_4, "3C買賣 SONY PlayStation SCPH-7501 遊戲主機", "$120", "$95"));
                        homeRecycleviewAdapater.addData(new Product(R.drawable.commodity_5, "[貓貓蟲-咖波] 經典造型 絨毛娃娃", "$120", "$95"));
                        homeRecycleviewAdapater.addData(new Product(R.drawable.commodity_6, "手機電視棒-支援IOS12 電視棒 M5 手機電視同屏顯示 手機連電視 HDMI AnycastPlus", "$120", "$95"));
                        finalLoadingDoneCallbacks.LoadingDone();

                    }
                });
            }
        }).start();
    }
}
