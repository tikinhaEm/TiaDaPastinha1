package tika.com.br.tiadapastinha;

/**
 * Created by Nelson on 3/8/2017.
 */

public class Item {
    String descItem;
    int qtdeItem;

    public Item(String descItem,int qtdeItem) {
        super();
        this.descItem = descItem;
        this.qtdeItem = qtdeItem;
    }

    public String getDescItem() {
        return descItem;
    }

    public void setDescItem(String descItem) {
        this.descItem = descItem;
    }

    public int getQtdeItem() {
        return qtdeItem;
    }

    public void setQtdeItem(int qtdeItem) {
        this.qtdeItem = qtdeItem;
    }
}
