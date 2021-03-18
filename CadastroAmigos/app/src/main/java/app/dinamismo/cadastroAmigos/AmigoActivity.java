package app.dinamismo.cadastroAmigos;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class AmigoActivity extends AppCompatActivity {

    TextView txtID;
    EditText edtNome;
    EditText edtTelefone;
    EditText edtEmail;
    Button btnCancelar;
    Button btnGravar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amigo);

        btnCancelar = (Button)findViewById(R.id.btnCancelar);
        btnGravar   = (Button)findViewById(R.id.btnGravar);
        //
        edtNome = (EditText)findViewById(R.id.edtNome);
        edtTelefone = (EditText)findViewById(R.id.edtTelefone);
        edtEmail = (EditText)findViewById(R.id.edtEmail);
        //
        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });

        btnGravar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Amigo amigo = new Amigo();
                amigo.setNome(edtNome.getText().toString());
                amigo.setTelefone(edtTelefone.getText().toString());
                amigo.setEmail(edtEmail.getText().toString());

                DBHelper db = new DBHelper(view.getContext());
                db.inserir(amigo);
                finish();
            }
        });


    }
}