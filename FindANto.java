package com.example.eres.room4p2;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class FindANto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_anto);
        final String mainText = getIntent().getExtras().getString("mainText");
        final String nofound = "Word not Found";
        new AsyncTask<Context, Void, Void>() {
            @Override
            protected Void doInBackground(Context... voids) {
                if (AppDatabase.getFileDatabase(voids[0]).userModel().findByName(mainText) != null) {
                    String antonym = AppDatabase.getFileDatabase(voids[0]).userModel().findByName(mainText).getAnto();
                      ((TextView) findViewById(R.id.antonym)).setText(antonym);
                }
               else if (AppDatabase.getFileDatabase(voids[0]).userModel().findByName(mainText) == null) {
                    TextView result = findViewById(R.id.wordnotfoundbutton);
                    result.setText(nofound);
                    result.showContextMenu();

                  }

                return null;
            }
        }.execute(this);
    }
}
