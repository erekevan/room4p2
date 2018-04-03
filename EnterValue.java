package com.example.eres.room4p2;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;


public class EnterValue extends AppCompatActivity  {
    private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_value);
        final AppDatabase database = AppDatabase.getFileDatabase(getApplicationContext());
        final User user = new User();
        Button submitButton = findViewById(R.id.Submit_button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText oWord =  findViewById(R.id.original_word);
                String oriword = oWord.getText().toString();
                user.setWordId(oriword);
                EditText ant = findViewById(R.id.the_Antonym);
                String anWord = ant.getText().toString();
                user.setAnto(anWord);
                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... voids) {
                        database.userModel().insertUser(user);
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Void aVoid) {
                        Intent goToValueAct = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(goToValueAct);
                    }
                }.execute();


                Log.wtf(MainActivity.class.getCanonicalName(), "Button e.v has been clicked");


            }
        });
    }

    private void displayList(){
        AppDatabase fileDatabase = database.getFileDatabase(EnterValue.this);


    }
}
