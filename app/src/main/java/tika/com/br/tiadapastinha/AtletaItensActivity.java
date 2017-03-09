package tika.com.br.tiadapastinha;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nelson on 2/15/2017.
 */

public class AtletaItensActivity extends AppCompatActivity {
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atleta_itens);

        List<Item> listItens = new ArrayList<Item>();
        listItens.add(new Item("Item 1",0));
        listItens.add(new Item("Item 2",0));
        listItens.add(new Item("Item 3",0));

        ListView listView = (ListView) findViewById(R.id.listaItensAtleta);

        ItemAtletaAdapter adapter = new ItemAtletaAdapter(listItens,this);
        listView.setAdapter(adapter);

    }

}
