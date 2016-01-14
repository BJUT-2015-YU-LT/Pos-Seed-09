package domains;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/1/5.
 */
public class ShoppingChart {
    public ShoppingChart(){}

    private ArrayList<Item> items = new ArrayList<Item>();

    public void add(Item item) {
        this.items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
