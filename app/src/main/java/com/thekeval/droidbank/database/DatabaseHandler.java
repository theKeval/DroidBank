package com.thekeval.droidbank.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DroidBank";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_createTable =
                "CREATE TABLE BankData (" +
                        "json VARCHAR" +
                        ")";

        db.execSQL(query_createTable);
        addJson("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS BankData");

        // Create tables again
        onCreate(db);
    }

    public void addJson(String jSon) {
        String insertQuery =
                "INSERT INTO BankData (json)" +
                        "VALUES (" + jSon + ")";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertQuery);
    }

    public void updateJson(String jSon) {
        String updateQuery =
                "UPDATE BankData SET json='" + jSon + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(updateQuery);
    }

}
