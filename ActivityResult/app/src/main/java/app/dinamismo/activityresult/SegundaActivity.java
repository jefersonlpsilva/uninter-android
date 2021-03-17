package app.dinamismo.activityresult;

import android.content.Intent;
import android.view.View;
import android.widget.RadioButton;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class SegundaActivity extends AppCompatActivity {

    RadioButton rbOpcao1;
    RadioButton rbOpcao2;
    RadioButton rbOpcao3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        rbOpcao1 = (RadioButton)findViewById(R.id.rbOpcao1);
        rbOpcao2 = (RadioButton)findViewById(R.id.rbOpcao2);
        rbOpcao3 = (RadioButton)findViewById(R.id.rbOpcao3);

        rbOpcao1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("retorno", "Primeira Opção");
                setResult(RESULT_OK, intent ) ;
                finish();
            }
        });

        rbOpcao2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent de retorno de dados
                Intent intent = new Intent() ;
                intent.putExtra("retorno", "Segunda Opção");
                setResult(RESULT_OK, intent );
                finish();
            }
        });

        rbOpcao3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent();
                intent.putExtra("retorno", "Terceira Opção");
                setResult(RESULT_OK, intent );
                finish();
            }
        });
    }
}