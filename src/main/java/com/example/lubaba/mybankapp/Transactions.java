package com.example.lubaba.mybankapp;

public class Transactions {

    private int _id;
    private String _date;
    private String _merchantDesc;
    private String _amount;

    public Transactions(int _id, String _date, String _merchantDesc, String _amount) {
        this._id = _id;
        this._date = _date;
        this._merchantDesc = _merchantDesc;
        this._amount = _amount;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }

    public String get_merchantDesc() {
        return _merchantDesc;
    }

    public void set_merchantDesc(String _merchantDesc) {
        this._merchantDesc = _merchantDesc;
    }

    public String get_amount() {
        return _amount;
    }

    public void set_amount(String _amount) {
        this._amount = _amount;
    }
}
