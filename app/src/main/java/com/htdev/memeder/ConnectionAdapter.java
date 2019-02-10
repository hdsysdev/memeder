package com.htdev.memeder;

import android.util.Log;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class ConnectionAdapter {
    //TODO: Add function to load several memes and return meme list
    Meme currentMeme;
    AsyncHttpClient httpClient = new AsyncHttpClient();
    String url = "http://192.168.0.11/fetch_memes.php";
    Gson gson = new Gson();
    ConnectionAdapter() {
        httpClient.setURLEncodingEnabled(false);

    }

    Meme getMeme(Integer id){
        RequestParams params = new RequestParams("ID", id);

        httpClient.post(url, params, new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Log.v("CONNECTION", response.toString());
                currentMeme = gson.fromJson(response.toString(), Meme.class);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Log.v("CONNECTION", "Cant connect");
                currentMeme = new Meme(0, "Not found", "meme.jpg", 10 );
            }
        });
        return currentMeme;
    }
}
