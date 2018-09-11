package com.example.lubaba.mybankapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class AccountDbHandler  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABSE_NAME="accounts.db";
    public static final String TABLE_ACCOUNTS="accounts";
    public static final String COLOUMN_ID="_id";
    public static final String COLOUMN_ACCOUNTTYPE="accountType";
    public static final String COLOUMN_ACCOUNTNUMBER="accountNumber";
    public static final String COLOUMN_ACCOUNTBALANCE="accountBalance";

    public AccountDbHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABSE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_ACCOUNTS);
        onCreate(db);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_ACCOUNTS + "(" +
                COLOUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLOUMN_ACCOUNTTYPE + " TEXT, " + COLOUMN_ACCOUNTNUMBER+ " TEXT, "
                + COLOUMN_ACCOUNTBALANCE+ " TEXT " +
                ");";
        db.execSQL(query);
    }

    public void addAccount(Accounts accounts)
    {
        ContentValues values = new ContentValues();
        values.put(COLOUMN_ACCOUNTTYPE,accounts.get_accountType());
        values.put(COLOUMN_ACCOUNTNUMBER,accounts.get_accountNumber());
        values.put(COLOUMN_ACCOUNTBALANCE,accounts.get_accountBalance());
        SQLiteDatabase db= getWritableDatabase();
        db.insert(TABLE_ACCOUNTS,null,values);
        db.close();
    }

    public String databasetostring(){
        String dbString="";
        SQLiteDatabase db= getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_ACCOUNTS + " WHERE 1";
        Cursor c =db.rawQuery(query,null);
        c.moveToFirst();
        while (!c.isAfterLast())
        {
            if(c.getString(c.getColumnIndex("accountType"))!=null)
            {
                dbString+= c.getString(c.getColumnIndex("accountType")) +c.getString(c.getColumnIndex("accountNumber"));
                dbString+="\n";
            }
            c.moveToNext();
        }
        db.close();
        return dbString;
    }

    public List<Accounts> getAllAccounts() {
        List<Accounts> contactList = new ArrayList<Accounts>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_ACCOUNTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Accounts accounts = new Accounts();
                accounts.set_id(Integer.parseInt(cursor.getString(0)));
                accounts.set_accountNumber(cursor.getString(1));
                accounts.set_accountType(cursor.getString(2));
                accounts.set_accountBalance(cursor.getString(3));


                // Adding contact to list
                contactList.add(accounts);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
}
