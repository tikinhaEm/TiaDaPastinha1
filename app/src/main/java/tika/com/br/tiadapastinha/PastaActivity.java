package tika.com.br.tiadapastinha;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nelson on 2/14/2017.
 */

public class PastaActivity extends AppCompatActivity {
    String[] atletas= {
            "Atleta1",
            "Atleta2",
            "Atleta3",
            "Atleta4",
            "Atleta5",
            "Atleta6"
    };
    private ListView listview;
    private Button btnSelecionarAtleta;
    private Toolbar toolbar;
    final Context context = this;
    private Animation animShow;
    private ViewGroup view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasta);

        // ***** TOOLBAR ******
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("Nome da Pasta");
        setSupportActionBar(toolbar);


        // ***** LISTVIEW SEM CHECKBOX *****
        listview = (ListView) findViewById(android.R.id.list);
        listview.setTextFilterEnabled(true);
        listview.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,atletas));
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PastaActivity.this, AtletaItensActivity.class);
                startActivity(intent);
            }
        });


        // **** BOTAO PARA SELECIONAR ATLETA ****
        btnSelecionarAtleta = (Button) findViewById(R.id.btnSelecionarAtleta);
        btnSelecionarAtleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PastaActivity.this, SelecionarAtletaActivity.class);
                startActivity(intent);
            }
        });


        // ***** RODAPÉ *****
        animShow = AnimationUtils.loadAnimation( this, R.anim.view_show);
        view = (ViewGroup) findViewById(R.id.layoutteste);
        view.setVisibility(View.VISIBLE);
        view.startAnimation( animShow );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(PastaActivity.this, "Esse e um toast", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
//    public void onListItemClick(ListView parent, View v, int position, long id){
//        Intent intent = new Intent(PastaActivity.this, AtletaItensActivity.class);
//        startActivity(intent);
//
//    }
}
