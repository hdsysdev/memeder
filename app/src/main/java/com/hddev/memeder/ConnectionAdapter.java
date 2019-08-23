package com.hddev.memeder;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.gson.Gson;

import java.util.List;

public class ConnectionAdapter {
    //TODO: Add function to load several memes and return meme list
    Meme currentMeme;

    Gson gson = new Gson();
    String url = "http://100.67.178.217/fetch_memes.php";
    private Handler mHandler = new Handler(Looper.getMainLooper());

//    StorageReference

    ConnectionAdapter() {


    }

    Meme getMeme(Integer id){

        final MemeHolder memeHolder = new MemeHolder();

        // Access a Cloud Firestore instance from your Activity
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        /*!
        Loading images is a 2 stage process. The meme info like points and uploader name.
        First stage is getting image name from id and returning full meme object.
        Second stage is getting image from firestore and populating the image view in the card adapter.
         */
        DocumentReference docRef = db.collection("memes")
                .document("xTNXbNXNOpFHGzOWG2jh");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d("Document", "DocumentSnapshot data: " + document.getData());
                        //Set meme variables from firebase document
                        memeHolder.meme.setID(document.getDouble("num").intValue());
                        memeHolder.meme.setPostedBy(document.getString("PostedBy"));
                        memeHolder.meme.setImageName(document.getString("ImageName"));
                        memeHolder.meme.setRating(document.getDouble("Rating").intValue());

                    } else {
                        Log.d("Document", "No such document");
                    }
                } else {
                    Log.d("Document", "get failed with ", task.getException());
                }
            }
        });

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
        final MemeHolder memeHolder = new MemeHolder();
//        FrameLayout progressBar = (FrameLayout) view.findViewById(R.id.progressBarHolder);
//        progressBar.setVisibility(View.VISIBLE);

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

    public static void uploadMeme(String absolutePath){

    }

    public static class MemeHolder {
        public Meme meme = new Meme(0, "Not found", "meme.jpg", 10 );
        public Meme[] memeList;
    }
}


