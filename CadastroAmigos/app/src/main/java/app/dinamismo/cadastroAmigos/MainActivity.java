package app.dinamismo.cadastroAmigos;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAmigo;
    ListView listAmigos;
    AmigoAdapter amigoAdapter;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAmigo = (Button)findViewById(R.id.btnAmigo);

        listAmigos = (ListView) findViewById(R.id.listAmigos);
        dbHelper = new DBHelper(this);


        btnAmigo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AmigoActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        listaAmigos();
    }

    public void listaAmigos(){
        ArrayList<Amigo> amigos = dbHelper.listar();
        amigoAdapter = new AmigoAdapter(this,amigos);
        listAmigos.setAdapter(amigoAdapter);
    }
}