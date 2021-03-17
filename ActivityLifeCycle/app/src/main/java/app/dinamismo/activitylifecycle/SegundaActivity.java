package app.dinamismo.activitylifecycle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 *  Primeiro passo criar o arquivo java
 *  Segundo passo criar o arquivo layout .xml
 *  terceiro passo set onCreate e mostrar a view
 *  terceiro passo adicionar manifest
 */

public class SegundaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);
    }
}
