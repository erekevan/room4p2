package com.example.eres.room4p2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button goToValuesScreen = findViewById(R.id.enter_values);
        goToValuesScreen.setOnClickListener(new View.OnClickListener() {
            // This step is to log the activity in the main method.
            @Override
            public void onClick(View view) {
                Log.wtf(MainActivity.class.getCanonicalName(), "Button e.v has been clicked");
                //linking this screen with another.
                Intent goToValueAct = new Intent(getApplicationContext(), EnterValue.class);
                //go to the actual screen
                startActivity(goToValueAct);
            }
        });

        Button goToFindScreen = findViewById(R.id.find_ant);
        goToFindScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText mainText = findViewById(R.id.main_Word_qeue);
                Intent goToFind= new Intent(getApplicationContext(), FindANto.class);
                //holds the word to search the data base for the word in the next page
                goToFind.putExtra("mainText", mainText.getText().toString());
                startActivity(goToFind);
            }
        });

    }


}
