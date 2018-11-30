package ohyeah5566.ui.ui;

/**
 * Created by yiwei on 2018/11/30.
 */
public class Product {

    private int imageID;
    private String name;
    private String specPrice;
    private String originPrice;

    public Product(int imageID, String name, String specPrice, String originPrice) {
        this.imageID = imageID;
        this.name = name;
        this.specPrice = specPrice;
        this.originPrice = originPrice;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecPrice() {
        return specPrice;
    }

    public void setSpecPrice(String specPrice) {
        this.specPrice = specPrice;
    }

    public String getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(String originPrice) {
        this.originPrice = originPrice;
    }
}
