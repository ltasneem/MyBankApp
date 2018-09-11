package com.example.lubaba.mybankapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {

    private static final String TAG = "myApp";
    private static final int size = 3;
    AccountDbHandler dbHandler;
    ArrayList<Accounts> accounts = new ArrayList<>();
    EditText dbText;
    TextView typeText;
    AccountAdapter accAdapt;
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        dbText = (EditText) findViewById(R.id.editTextTransaction);

        lv = (ListView) findViewById(R.id.list1);

        Log.v(TAG, "account");

        accounts.add(new Accounts(1,"1234567890","Checking","$234.23"));
        accounts.add(new Accounts(2,"2345678901","Savings","$3463.52"));
        accounts.add(new Accounts(3,"23456789012","Credit","$23.21"));

        Log.v(TAG, String.valueOf(accounts.size()));
        dbHandler =new AccountDbHandler(this,null,null,1);
        for(Accounts acc : accounts){
            dbHandler.addAccount(acc);
        }

        //dbHandler.addAccount(new Accounts(1,"1234567890","Checking","$234.23"));

        populateListView();

       // String dbSting= dbHandler.databasetostring();
       // dbText.setText(dbSting);

    }

    private void populateListView(){

       // lv = (ListView) findViewById(R.id.list1);

        List<Accounts> maccounts = dbHandler.getAllAccounts();
        List<Accounts> accounts = new ArrayList<Accounts>();
        for(int i =0; i<size;i++){
            accounts.add(maccounts.get(i));
        }
        Log.v(TAG, String.valueOf(accounts.size()));
       // accAdapt = new AccountAdapter(this,R.layout.display_account_row);
        accAdapt=new AccountAdapter(this, accounts);
        //accAdapt.add(accounts);

        lv.setAdapter(accAdapt);

    }
}
