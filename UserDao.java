package com.example.eres.room4p2;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import static java.nio.charset.CodingErrorAction.IGNORE;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> loadAllUsers();

    @Query("select * from user WHERE wordId=(:wordid)")
    List<User> loadAllByIds(String wordid);

    @Query("SELECT * FROM user WHERE wordId=(:anto)")
    User findByName(String anto);

    @Insert
    void insertUser(User... users);

    @Delete
    void delete(User user);
}