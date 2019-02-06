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

import java.util.List;


public class CardAdapter extends ArrayAdapter {

    private Context mContext;
    private List<Meme> memeList;

    public CardAdapter(@NonNull Context context, int resource, List<Meme> memes) {
        super(context, resource);
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

        TextView textView = (TextView) cardView.findViewById(R.id.cardTextView);
        textView.setText(currentMeme.getPostedBy());
        return cardView;
    }
}
