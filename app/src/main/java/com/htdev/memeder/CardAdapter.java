package com.htdev.memeder;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class CardAdapter extends ArrayAdapter<Meme> {

    private Context mContext;
    private List<Meme> memeList;
    private String URL = "http://192.168.0.11/img/";
    public CardAdapter(@NonNull Context context, int resource, List<Meme> memes) {
        super(context, resource, memes);
        mContext = context;
        memeList = memes;
    }

    @Override
    public View getView(int position, @Nullable View convertView, ViewGroup parent) {
        View cardView = convertView;
        if(cardView == null)
            cardView = LayoutInflater.from(mContext).inflate(R.layout.card_view, parent,false);
        Meme currentMeme = memeList.get(position);

        ImageView imageView = (ImageView) cardView.findViewById(R.id.cardImage);
        //TODO: Add image from url with image library
        Glide.with(cardView).load("https://i.imgflip.com/25p6ij.jpg").into(imageView);


        TextView textView = (TextView) cardView.findViewById(R.id.cardTextView);
        textView.setText("A meme");
        return cardView;
    }
}
