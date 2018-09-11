package com.example.lubaba.mybankapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter extends ArrayAdapter {
    //List list = new ArrayList<>();

    Context context;
    List<Accounts> accounts;


    public AccountAdapter(Context context, List<Accounts> accounts){
        super(context, R.layout.display_account_row, accounts);
        this.context=context;
        this.accounts=accounts;
    }

    /*
    public AccountAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }


    public void add(List<Accounts> accounts) {
        list = accounts;
        super.add(accounts);
    }*/

    @Override
    public int getCount() {
        return super.getCount();
    }



    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        AccountHolder accountHolder;

        Accounts data = (Accounts)getItem(position);

        if(row ==null){
            //LayoutInflater layoutInflater =(LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LayoutInflater layoutInflater =LayoutInflater.from(getContext());
            row = layoutInflater.inflate(R.layout.display_account_row, parent, false);
            accountHolder = new AccountHolder();

            accountHolder.typeText = (TextView)row.findViewById(R.id.TypeText);
            accountHolder.numberText = (TextView)row.findViewById(R.id.NumberText);
            accountHolder.balanceText = (TextView)row.findViewById(R.id.BalanceText);
            row.setTag(accountHolder);
        }

        else{
            accountHolder = (AccountHolder) row.getTag();
        }

        accountHolder.typeText.setText(data.get_accountType());
        accountHolder.numberText.setText(data.get_accountNumber());
        accountHolder.balanceText.setText(data.get_accountBalance());

        return row;
    }

    static class AccountHolder{

        TextView typeText,numberText,balanceText;
    }
}
