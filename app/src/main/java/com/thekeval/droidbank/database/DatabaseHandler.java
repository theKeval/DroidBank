package com.thekeval.droidbank.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DroidBank";
    private static final String TABLE_NAME = "BankData";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query_createTable =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        "json VARCHAR" +
                        ")";

        db.execSQL(query_createTable);
        addJson("");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );

        // Create tables again
        onCreate(db);
    }

    private void addJson(String jSon) {
        String insertQuery =
                "INSERT INTO " + TABLE_NAME + " (json)" +
                        "VALUES (" + jSon + ")";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(insertQuery);
    }

    public void updateJson(String jSon) {
        String updateQuery =
                "UPDATE " + TABLE_NAME + " SET json='" + jSon + "'";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(updateQuery);
    }

    public String getJson() {
        String jSon = "";

        String getQuery =
                "SELECT * from " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(getQuery, null);

        if (cursor.moveToFirst()) {
            jSon = cursor.getString(0);
        }

        return jSon;
    }

}
