package com.thekeval.droidbank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.thekeval.droidbank.adapter.AccountsAdapter;
import com.thekeval.droidbank.model.BankAccount;
import com.thekeval.droidbank.model.CustomerAccounts;
import com.thekeval.droidbank.util.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // UI elements references
    RecyclerView rv_accounts;

    // variable declarations
    ArrayList<BankAccount> lstAccounts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // getting UI elements references
        rv_accounts = findViewById(R.id.rv_accounts);

        // initialization
        lstAccounts = new ArrayList<>();
        fillAccounts();
        AccountsAdapter accAdapter = new AccountsAdapter(this, lstAccounts);
        rv_accounts.setAdapter(accAdapter);
        rv_accounts.setLayoutManager(new LinearLayoutManager(this));
    }

    public void fillAccounts() {
        CustomerAccounts accs = Constants.loggedInCustomer.getAccounts();
        if (accs.getSavingAcc() != null) {
            lstAccounts.add(accs.getSavingAcc());
        }

        if (accs.getSalaryAcc() != null) {
            lstAccounts.add(accs.getSalaryAcc());
        }

        if (accs.getFdAcc() != null) {
            lstAccounts.add(accs.getFdAcc());
        }
    }
}