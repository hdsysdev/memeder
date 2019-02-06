package com.htdev.memeder;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ConnectionAdapter {
    //TODO: Add function to load several memes and return meme list

    AsyncHttpClient httpClient = new AsyncHttpClient();
    String url = "http://192.168.0.11/connection.php";
    public ConnectionAdapter() {
        httpClient.setURLEncodingEnabled(false);
        httpClient.get(url, null, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.v("CONNECTION", response.toString());
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.v("CONNECTION", "Cant connect");
            }
        });

    }
}
