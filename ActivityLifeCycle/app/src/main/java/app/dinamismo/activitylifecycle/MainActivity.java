package app.dinamismo.activitylifecycle;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public static String ACTIVITY = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ACTIVITY, "onCreate()");

        //Adiciona reconhce o botao(objeto) do arquivo xml
        Button btnSegundaActivity = (Button)findViewById(R.id.button);
        //
        btnSegundaActivity.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(v.getContext(), SegundaActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d(ACTIVITY, "onStart()");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d(ACTIVITY, "onResume()");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d(ACTIVITY, "onPause()");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d(ACTIVITY, "onStop()");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(ACTIVITY, "onRestart()");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(ACTIVITY, "onDestroy()");
    }

}