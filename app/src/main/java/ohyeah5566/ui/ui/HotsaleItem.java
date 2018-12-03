package ohyeah5566.ui.ui;

/**
 * Created by yiwei on 2018/11/28.
 */
public class HotsaleItem {
    private int imageID;
    private String commodityName;
    private String price;
    private String priceOrigin;

    public HotsaleItem(int imageID, String commodityName, String price, String priceOrigin) {
        this.imageID = imageID;
        this.commodityName = commodityName;
        this.price = price;
        this.priceOrigin = priceOrigin;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceOrigin() {
        return priceOrigin;
    }

    public void setPriceOrigin(String priceOrigin) {
        this.priceOrigin = priceOrigin;
    }
}
