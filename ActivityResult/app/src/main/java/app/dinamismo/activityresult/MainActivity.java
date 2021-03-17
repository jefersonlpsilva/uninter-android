package app.dinamismo.activityresult;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    TextView resultado;
    Button btnOpcao;
    Button btnArgumento;
    Button btnEnviaPojo;

    static int ACAO_BUSCA_PREFERENCIA_USER = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //ligamos o componente btnOpcao a representacao no arquivo xml
        btnOpcao =(Button)findViewById(R.id.btnOpcao);
        //ligamos o componente btnArgumento a representacao no arquivo xml
        btnArgumento = (Button)findViewById(R.id.btnArgumento);

        btnEnviaPojo = (Button) findViewById(R.id.btnEnviaPojo);

        //redefinir o listener OnClickListener
        btnOpcao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), SegundaActivity.class);
                startActivityForResult(intent, ACAO_BUSCA_PREFERENCIA_USER);
            }
        });

        btnArgumento.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(view.getContext(), TerceiraActivity.class);
                intent.putExtra("retorno","Seu argumento chegou!!!");
                startActivity(intent);
            }
        });

        btnEnviaPojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = new Cliente();
                cliente.setNome("Jeferson");
                cliente.setIdade(43);
                cliente.setEndereco("Rua São Paulo, 319, apto 202, centro, sao leopoldo");

                Intent intent = new Intent(view.getContext(), TerceiraActivity.class);
                intent.putExtra("cliente",cliente);
                startActivity(intent);
            }
        });

    }

    //Monitoramente do retorna a actividade
    //Eh onActivityResult por activity,
    //requestCode que mostra a origem do retorno da chamada
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        // ligamos o componente resultado à representação no arquivo xml
        resultado = (TextView)findViewById(R.id.resultado);
        resultado.setText("");
        //Verifica o tipo de request code
        if (requestCode == ACAO_BUSCA_PREFERENCIA_USER) {
            // verifica se o usuario encerrou a activity retornando sua opcao
            if (resultCode == RESULT_OK ) {
                // ligamos o componente resultado à representação no arquivo xml
                //resultado = (TextView)findViewById(R.id.resultado);
                // passamos o valor intent (uma string) para o resultado.setText
                resultado.setText(data.getStringExtra("retorno"));
            }
        }
    }
}