package tika.com.br.tiadapastinha;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Nelson on 3/6/2017.
 */

public class ItemAtletaAdapter extends BaseAdapter {

    private Context context;
    private final List<Item> listaItens;
    private Activity act;

    public ItemAtletaAdapter(List<Item> listaItens, Activity act) {
        this.listaItens = listaItens;
        this.act = act;
    }

    @Override
    public int getCount() {
        return listaItens.size();
    }

    @Override
    public Object getItem(int position) {
        return listaItens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.item_atleta, parent,false);

        Item item = listaItens.get(position);
        TextView descItem = (TextView) view.findViewById(R.id.descItem);
        EditText qtdeItem = (EditText) view.findViewById(R.id.qtdeItem);

        descItem.setText(item.getDescItem());
        //qtdeItem.setText("0");

        return view;
    }
}
