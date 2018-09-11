package com.example.lubaba.mybankapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    //  HTTP request
    String bankWebserviceURL = "https://qeefy9o78j.execute-api.us-east-1.amazonaws.com/HelloWorldAPI/aws-serverless-repository-hello-world-helloworld-OF9SDOHA1OI\n";
    //the loading Dialog
    ProgressDialog pDialog;
    // Textview to show id
   EditText idText;
    // JSON object that contains weather information
    JSONObject jsonObj;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idText = (EditText) findViewById(R.id.editTextId);

        RestClient restClient = new RestClient(bankWebserviceURL);



       /* RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest request = new JsonObjectRequest(bankWebserviceURL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (null != response) {
                            try {
                                jsonObj = (JSONObject) response.getJSONArray("bankAccount").get(0);

                                idText.setText(jsonObj.getString("id"));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(request);

        */
        /*pDialog = new ProgressDialog(this);
        pDialog.setMessage("Please wait while retrieving the account information ...");
        pDialog.setCancelable(false);
        pDialog.show();

// make HTTP request to retrieve the info with id
        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                bankWebserviceURL, null, new Response.Listener() {

            @Override
            public void onResponse(Object response) {

            }

            public void onResponse(JSONObject response) {
                try {
                    // Parsing json object response
                    // response will be a json object


                    jsonObj = (JSONObject) response.getJSONArray("bankAccount").get(0);

                    idText.setText(jsonObj.getString("id"));



                    // hide the loading Dialog
                    pDialog.dismiss();


                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Error , try again ! ", Toast.LENGTH_LONG).show();
                    pDialog.dismiss();

                }


            }


        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("tag", "Error: " + error.getMessage());
                Toast.makeText(getApplicationContext(), "Error while loading ... ", Toast.LENGTH_SHORT).show();
                // hide the progress dialog
                pDialog.dismiss();
            }
        });

        // Adding request to request queue
        AppController.getInstance(this).addToRequestQueue(jsonObjReq);

        */

        /*OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = httpClient.newCall(request).execute();
        String body = response.body().string();
        */

        /*
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset());
            JSONArray m_jArry = obj.getJSONArray("bankId");
            ArrayList<HashMap<String, String>> formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("id"));
                String formula_value = jo_inside.getString("accounts");


                //Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("formule", formula_value);


                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */


        /*
        RestClient client = new RestClient(LOGIN_URL);
        client.AddParam("accountType", "GOOGLE");
        client.AddParam("source", "tboda-widgalytics-0.1");
        client.AddParam("Email", _username);
        client.AddParam("Passwd", _password);
        client.AddParam("service", "analytics");
        client.AddHeader("GData-Version", "2");

        try {
            client.Execute(RequestMethod.POST);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = client.getResponse();
        *
        * */

        /*
        * URL url = new URL("http://www.android.com/");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                 InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                 readStream(in);
            }
            finally {
                 urlConnection.disconnect();
            }
        */

    }

    public void buttonAccountOnClick(View view) {
        Intent i = new Intent(this,AccountActivity.class);

        //userId will be passed through intent to show account details.

        //final EditText firstInput = (EditText) findViewById(R.id.firstInput);

        //String userMessage = firstInput.getText().toString();

        //i.putExtra("firstMessage",userMessage);

        startActivity(i);
    }

    public void buttonTransactionOnClick(View view) {
        Intent i = new Intent(this,TransactionActivity.class);
        startActivity(i);
    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getContext().getAssets().open("bankAccount.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public Context getContext() {
        return context;
    }
}
