package com.thekeval.droidbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.thekeval.droidbank.model.DataModel;
import com.thekeval.droidbank.util.Constants;
import com.thekeval.droidbank.util.FileUtils;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // App Initialization
        // FileUtils.getInstance(this).saveData(Constants.ReadyMadeJson);

        DataModel data = FileUtils.getInstance(getBaseContext()).getData();
        if (data != null) {
            Constants.customers = data;
        }

        // getting UI elements references
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please enter Username and Password to Login!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (username.toLowerCase().equals("keval") && password.toLowerCase().equals("123")) {
                    Constants.loggedInCustomer = Constants.customers.getCustomers().get(0);

                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}