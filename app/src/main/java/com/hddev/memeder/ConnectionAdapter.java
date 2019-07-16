package com.hddev.memeder;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.List;

import static com.google.android.gms.plus.PlusOneDummyView.TAG;

public class ConnectionAdapter {
    //TODO: Add function to load several memes and return meme list
    Meme currentMeme;
//    OkHttpClient httpClient = new OkHttpClient();

    /**
     *
     */
    Gson gson = new Gson();
    String url = "http://100.67.178.217/fetch_memes.php";
    private Handler mHandler = new Handler(Looper.getMainLooper());
//    Gson gson = new Gson();

    FirebaseFirestore db = FirebaseFirestore.getInstance();
    DocumentReference docRef;
//    private DatabaseReference mDatabase;
    ConnectionAdapter() {
        docRef = db.collection("memes").document("guiyGIT7DxUpGF0Z5hgR");
    }

    Meme getMeme(Integer id){
//        RequestBody requestBody = new FormBody.Builder()
//                .add("ID", id.toString())
//                .build();
//
//        Request request = new Request.Builder()
//                .url(url)//                .post(requestBody)
//                .build();
        final MemeHolder memeHolder = new MemeHolder();


//        try (Response response = httpClient.newCall(request).execute()) {
//            String responseTmp = response.body().string();
//            Log.e("CONNECTION", responseTmp);
//            memeHolder.meme = moshiAdapter.fromJson(responseTmp);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
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
//                    memeHolder.meme = gson.fromJson(responseTmp, Meme.class);
//                }
//            }
//        });

        return memeHolder.meme;
    }
    public void loadMemes(View view, List<Meme> memeList, CardAdapter cardAdapter){
        //TODO: Remove ID 1 parameter and load amount of memes using new php function
//        RequestBody requestBody = new FormBody.Builder()
//                .add("amount", "5")
//                .build();
//
//        Request request = new Request.Builder()
//                .url(url)
//                .post(requestBody)
//                .build();
        final MemeHolder memeHolder = new MemeHolder();
//        FrameLayout progressBar = (FrameLayout) view.findViewById(R.id.progressBarHolder);
//        progressBar.setVisibility(View.VISIBLE);
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        //TODO: find out how to read fields 
                        memeHolder.meme = new Meme(0, "Jeff", "meme.png",0 );
                    } else {
                        Log.d(TAG, "No such document");
                    }
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }
            }
        });

//        httpClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                memeHolder.meme = new Meme(0, "Not found", "meme.jpg", 10 );
//                Log.e("CONNECTION", "CANT CONNECT");
//                progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                if (!response.isSuccessful()) {
//                    throw new IOException("Unexpected code " + response);
//                } else {
//                    String responseTmp = response.body().string();
//                    Log.e("CONNECTION", responseTmp);
//                    memeHolder.memeList = gson.fromJson(responseTmp, Meme[].class);
//
//
//                    mHandler.post(new Runnable() {
//                        @Override
//                        public void run() {
////                            cardAdapter.addAll(memeHolder.memeList);
//                            memeList.addAll(Arrays.asList(memeHolder.memeList));
//                            cardAdapter.notifyDataSetChanged();
//                            progressBar.setVisibility(View.GONE);
//                        }
//                    });
//                }
//            }
//        });

    }
    public static class MemeHolder {
        public Meme meme = new Meme(0, "Not found", "meme.jpg", 10 );
        public Meme[] memeList;
    }
}


