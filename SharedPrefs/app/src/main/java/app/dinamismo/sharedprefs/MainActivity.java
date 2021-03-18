package app.dinamismo.sharedprefs;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button btnAzul, btnVermelho, btnVerde, btnAmarelo, btnCeleste, btnLaranja;

    TextView txtTexto;
    EditText edtNome;
    Button btnGravar;
    RelativeLayout layout;
    String cor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAzul = (Button) findViewById(R.id.btnAzul);
        btnVermelho = (Button) findViewById(R.id.btnVermelho);
        btnVerde = (Button) findViewById(R.id.btnVerde);
        btnAmarelo = (Button) findViewById(R.id.btnAmarelo);
        btnCeleste = (Button) findViewById(R.id.btnCeleste);
        btnLaranja = (Button) findViewById(R.id.btnLaranja);
        layout = (RelativeLayout) findViewById(R.id.layoutPrincipal);
        btnGravar = (Button) findViewById(R.id.btnGravar);
        edtNome = (EditText) findViewById(R.id.edtNome);

        cor = "#FFFFFF";

        btnAzul.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cor = "#15279A";
                layout.setBackgroundColor(Color.parseColor(cor));
            }
        });

        btnVermelho.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cor =  "#ff0011";
                layout.setBackgroundColor(Color.parseColor(cor));
            }
        });

        btnVerde.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cor =  "#37ff00";
                layout.setBackgroundColor(Color.parseColor(cor));
            }
        });

        btnAmarelo.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cor =  "#ffe100";
                layout.setBackgroundColor(Color.parseColor(cor));
            }
        });

        btnCeleste.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cor = "#00fff7";
                layout.setBackgroundColor(Color.parseColor(cor));
            }
        });

        btnLaranja.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cor = "#ff8000";
                layout.setBackgroundColor(Color.parseColor(cor));
            }
        });

        btnGravar.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view){
                SharedPreferences prefs = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("nome",edtNome.getText().toString());
                editor.putString("cor",cor);
                editor.apply();
            }
        });

        carregarPrefs();

    }

    public void carregarPrefs(){
        SharedPreferences prefs =getPreferences(MODE_PRIVATE);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtNome.setText(prefs.getString("nome",""));
        cor = prefs.getString("cor","#FFFFFF");

        layout = (RelativeLayout) findViewById(R.id.layoutPrincipal);
        layout.setBackgroundColor(Color.parseColor(cor));
    }

}