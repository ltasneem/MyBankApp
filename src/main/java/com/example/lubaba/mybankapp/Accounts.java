package com.example.lubaba.mybankapp;

public class Accounts {

    private int _id;
    private String _accountNumber;
    private String _accountType;
    private String _accountBalance;

    public Accounts() {

    }

    public Accounts(int _id, String _accountNumber, String _accountType, String _accountBalance) {
        this._id = _id;
        this._accountNumber = _accountNumber;
        this._accountType = _accountType;
        this._accountBalance = _accountBalance;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_accountNumber() {
        return _accountNumber;
    }



    public void set_accountNumber(String _accountNumber) {
        this._accountNumber = _accountNumber;
    }

    public String get_accountType() {
        return _accountType;
    }

    public void set_accountType(String _accountType) {
        this._accountType = _accountType;
    }

    public String get_accountBalance() {
        return _accountBalance;
    }

    public void set_accountBalance(String _accountBalance) {
        this._accountBalance = _accountBalance;
    }
}
