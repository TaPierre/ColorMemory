package com.example.ColorMemoryFinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnEasy= findViewById( R.id.buttonEasy );
        Button btnHard= findViewById( R.id.buttonHard );
        Button btnExpert= findViewById( R.id.btn_expert );

        /* Pour chaque définition de bouton, on fait deux choses : On crée d'abord l'intent en
        définissant les classes de début et de fin, puis on lance l'intent, ce qui fait basculer
        l'application vers l'activité suivante (avec startActivity(intent)
        */

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("blocCount",3);
                intent.putExtra("LightCount",1);
                intent.putExtra("MaxLights",7);
                intent.putExtra("mode",1);
                intent.putExtra("Score",0.0);
                startActivity(intent);

            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("blocCount",3);
                intent.putExtra("LightCount",3);
                intent.putExtra("MaxLights",10);
                intent.putExtra("mode",2);
                intent.putExtra("Score",0);
                startActivity(intent);

            }
        });

        btnExpert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra("blocCount",3);
                intent.putExtra("LightCount",4);
                intent.putExtra("MaxLights",12);
                intent.putExtra("mode",3);
                intent.putExtra("Score",0);
                startActivity(intent);

            }
        });
    }
}
