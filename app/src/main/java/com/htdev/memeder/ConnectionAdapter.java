package com.htdev.memeder;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ConnectionAdapter {
    //TODO: Add function to load several memes and return meme list
    Meme currentMeme;
    OkHttpClient httpClient = new OkHttpClient();
    Moshi moshi = new Moshi.Builder().build();
    JsonAdapter<Meme> moshiAdapter = moshi.adapter(Meme.class);
    String url = "http://100.67.178.217/fetch_memes.php";
//    Gson gson = new Gson();
    ConnectionAdapter() {


    }

    Meme getMeme(Integer id){
        RequestBody requestBody = new FormBody.Builder()
                .add("ID", id.toString())
                .build();

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        final MemeHolder memeHolder = new MemeHolder();


        try (Response response = httpClient.newCall(request).execute()) {
            String responseTmp = response.body().string();
            Log.e("CONNECTION", responseTmp);
            memeHolder.meme = moshiAdapter.fromJson(responseTmp);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        httpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                memeHolder.meme = new Meme(0, "Not found", "meme.jpg", 10 );
//                Log.e("CONNECTION", "CANT CONNECT");
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                    throw new IOException("Unexpected code " + response);
//                } else {
//                    String responseTmp = response.body().string();
//                    Log.e("CONNECTION", responseTmp);
//                    memeHolder.meme = moshiAdapter.fromJson(responseTmp);
//                }
//            }
//        });

//        RequestParams params = new RequestParams("ID", id);
//
//        httpClient.post(url, params, new JsonHttpResponseHandler(){
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                super.onSuccess(statusCode, headers, response);
//                Log.v("CONNECTION", response.toString());
//                currentMeme = gson.fromJson(response.toString(), Meme.class);
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
//                super.onFailure(statusCode, headers, throwable, errorResponse);
//                Log.v("CONNECTION", "Cant connect");
//                currentMeme = new Meme(0, "Not found", "meme.jpg", 10 );
//            }
//        });

        return memeHolder.meme;
    }

    public static class MemeHolder {
        public Meme meme = new Meme(0, "Not found", "meme.jpg", 10 );
    }
}


