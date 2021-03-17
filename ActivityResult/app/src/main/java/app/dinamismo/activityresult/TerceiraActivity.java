package app.dinamismo.activityresult;

import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class TerceiraActivity extends AppCompatActivity {

    TextView valorParametro ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terceira);

        valorParametro = (TextView)findViewById(R.id.valorParametro);

        Intent intent = getIntent();
        if ((intent.hasExtra("retorno")) && ( null != intent.getStringExtra("retorno")))
          valorParametro.setText(intent.getStringExtra("retorno"));
        else if ((intent.hasExtra("cliente")) && (null !=intent.getSerializableExtra("cliente"))){
            Cliente cliente = (Cliente)intent.getSerializableExtra("cliente");
            valorParametro.setText("Cliente informando:"+ cliente.getNome()+"- "+cliente.getIdade()+" anos ");
        }



    }
}