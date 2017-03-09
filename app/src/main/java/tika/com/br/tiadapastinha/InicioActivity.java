package tika.com.br.tiadapastinha;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InicioActivity extends AppCompatActivity {
    final Context context = this;
    private Button btnCriarPasta;
    private Toolbar toolbar;
    private Animation animShow;
    private TextView gridView;
    private ViewGroup view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        // ***** TOOLBAR ******
        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        toolbar.setTitle("Tia da Pastinha!");
        setSupportActionBar(toolbar);


        // ***** BOTAO CRIAR NOVA PASTA *****
        btnCriarPasta = (Button) findViewById(R.id.btnCriarPasta);
        btnCriarPasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater li = LayoutInflater.from(context);
                View novaPastaView = li.inflate(R.layout.dialog_nome_pasta, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(novaPastaView);
                final EditText userInput = (EditText) novaPastaView
                        .findViewById(R.id.txtNomePasta);

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        // get user input and set it to result
                                        // edit text
//                                        result.setText(userInput.getText());
                                        Intent intent = new Intent(InicioActivity.this, PastaActivity.class);
                                        startActivity(intent);
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


        animShow = AnimationUtils.loadAnimation( this, R.anim.view_show);
//        gridView = (TextView) findViewById(R.id.lblTeste);
//        gridView.setVisibility(View.VISIBLE);
//        gridView.startAnimation( animShow );

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
                Toast.makeText(InicioActivity.this, "Esse e um toast", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
}
