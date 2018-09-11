package com.example.lubaba.mybankapp;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.EditText;

public class Empty extends
        AsyncTask<Void, Void, Boolean> {

    String urlString = "http://www.yoursite.com/";

    private final String TAG = "post json example";
    private Context context;

    private int advertisementId;

    private String postString;

    public Empty(Context contex, int advertisementId) {

        this.context = contex;
        this.advertisementId = advertisementId;
    }

    @Override
    protected void onPreExecute() {
        Log.e(TAG, "1 - RequestVoteTask is about to start...");

    }



    @Override
    protected Boolean doInBackground(Void... voids) {

        //  HTTP request
        String bankWebserviceURL = "https://qeefy9o78j.execute-api.us-east-1.amazonaws.com/HelloWorldAPI/aws-serverless-repository-hello-world-helloworld-OF9SDOHA1OI\n";
        String merchant = "{'merchant’:’TargetShop’}";

        RestClient restclient = new RestClient(bankWebserviceURL);

        postString = restclient.performPostCall(bankWebserviceURL,merchant);

        Log.e(TAG, postString);



        return null;
    }


}

