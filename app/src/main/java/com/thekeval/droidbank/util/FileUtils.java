package com.thekeval.droidbank.util;

import android.content.Context;

import com.google.gson.Gson;
import com.thekeval.droidbank.database.DatabaseHandler;
import com.thekeval.droidbank.model.*;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static com.thekeval.droidbank.util.Constants.*;

public class FileUtils {

    private static FileUtils objFileUtils = null;
    public static FileUtils getInstance(Context context) {
        if (objFileUtils == null)
            objFileUtils = new FileUtils(context);

        return objFileUtils;
    }

    DatabaseHandler db;

    public FileUtils(Context context) {
        // initialize
        db = new DatabaseHandler(context);
    }

    public String getJsonString(DataModel data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }

    public void saveData(String jsonString) {
        try {

            db.updateJson(jsonString);
            print("data saved");

        } catch (Exception ex) {
            print("error in saving data:");
            ex.printStackTrace();
        }
    }

    public void updateData() {
        customers.replaceCustomer(loggedInCustomer);

        String jsonStr = getJsonString(customers);
        saveData(jsonStr);
    }

    public DataModel getData() {
        DataModel data = null;

        try {
            // String dataString = db.getJson();

            Gson g = new Gson();
            data = g.fromJson(ReadyMadeJson, DataModel.class);

            // print(data.toString());

        } catch (Exception ex) {
            print("error reading data from file.");
            ex.printStackTrace();
        }

        return data;
    }

    public void print(String str) {
        System.out.println(str);
    }

}
