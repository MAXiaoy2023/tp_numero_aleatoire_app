package org.m2i.tp_numero_aleatoire_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    EditText guess;

    TextView counter_tentative, msg_txt, msg_final_txt;

    //Random random = new Random();
    //int numberAlea = random.nextInt(100);
    int numberAlea;
    Button btn_check, btn_rebegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    void start_game(){
        guess= findViewById(R.id.guess);
        msg_txt = findViewById(R.id.msg_txt);
        btn_check = findViewById(R.id.btn_check);
        msg_final_txt = findViewById(R.id.msg_final_txt);

        btn_rebegin = findViewById(R.id.btn_rebegin);
        btn_rebegin.setVisibility(View.INVISIBLE);

        Random random = new Random();
        numberAlea = random.nextInt(100);
        btn_check.setText("Vérifier");
        msg_final_txt.setText("");
        msg_txt.setText("");
    }

    @Override
    protected void onStart() {
        super.onStart();

        start_game();

        btn_check.setOnClickListener(new View.OnClickListener() {
            int counter=0;
            @Override
            public void onClick(View v) {
                int number_guess = Integer.parseInt(guess.getText().toString());
                //System.out.println("t="+ guess.getText().toString());

                if(number_guess < numberAlea) {
                    msg_txt.setText("Trop bas !");
                } else if (number_guess > numberAlea) {
                    msg_txt.setText("Trop élevé !");
                } else {
                    counter++;
                    System.out.println("222222222222/"+counter);
                    msg_txt.setText("Bonne réponse !");
                    msg_final_txt.setText("Félicitation - " + counter);

                    btn_rebegin.setVisibility(View.VISIBLE);
                    btn_rebegin.setText("Nouvelle partie");
                    btn_rebegin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            start_game();
                        }
                    });
                }
                counter++ ;
            }
        });
    }

}
