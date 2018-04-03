package com.example.eres.room4p2;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(primaryKeys = {"wordId", "anto"})
public class User {
    @NonNull
     public  String wordId="null";

    @NonNull
   public  String anto="null";

    public void setWordId(String x){
        wordId=x;
    }

    public String getWordId() {
        return wordId;
    }

    public void setAnto(String anto) {
        this.anto = anto;
    }

    public String getAnto() {
        return anto;
    }
    @Override
    public String toString(){
        return "this " + wordId + " Antonym is "+  anto;
    }
}