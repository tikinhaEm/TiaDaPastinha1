package tika.com.br.tiadapastinha;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by Nelson on 2/15/2017.
 */

public class SelecionarAtletaActivity extends ListActivity {

    private Button btnInserirAtleta;
    final Context context = this;
    String[] atletas= {
            "Atleta1",
            "Atleta2",
            "Atleta3",
            "Atleta4",
            "Atleta5",
            "Atleta6"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionar_atleta);

        // ***** LISTVIEW COM CHECKBOX *****
        ListView listview= getListView();
        listview.setChoiceMode(listview.CHOICE_MODE_MULTIPLE);
        listview.setTextFilterEnabled(true);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_checked,atletas));
        //listview.getCheckedItemPositions().get(0);


        // **** BOTAO PARA INSERIR ATLETA ****
        btnInserirAtleta = (Button) findViewById(R.id.btnInserirAtleta);
        btnInserirAtleta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View novoAtletaView = li.inflate(R.layout.dialog_novo_atleta, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(novoAtletaView);
                final EditText userInput = (EditText) novoAtletaView
                        .findViewById(R.id.txtNomeAtleta);

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text
//                                        result.setText(userInput.getText());
//                                        Intent intent = new Intent(SelecionarAtletaActivity.this, PastaActivity.class);
//                                        startActivity(intent);
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            }
        });
    }
}
