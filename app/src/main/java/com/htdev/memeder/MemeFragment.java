package com.htdev.memeder;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MemeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MemeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public MemeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MemeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MemeFragment newInstance(String param1, String param2) {
        MemeFragment fragment = new MemeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //TODO: Attach adapter to swipe card view
    }

    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_meme, container, false);

        ConnectionAdapter connectionAdapter = new ConnectionAdapter();
        List<Meme> memeList = new ArrayList<>();
//        memeList.add(connectionAdapter.getMeme(1));
//        memeList.add(new Meme(21, "Jeffina", "meme.jpg", 20));
        CardAdapter cardAdapter = new CardAdapter(getContext(), memeList);

        SwipeFlingAdapterView flingAdapterView = (SwipeFlingAdapterView) view.findViewById(R.id.frame);
        flingAdapterView.setAdapter(cardAdapter);
        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                memeList.remove(0);
                cardAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {

            }

            @Override
            public void onRightCardExit(Object o) {

            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
                connectionAdapter.loadMemes(view, memeList, cardAdapter);
            }


            @Override
            public void onScroll(float scrollProgressPercent) {

//                View view = flingAdapterView.getSelectedView();
//                view.findViewById(R.id.card_view).setAlpha(0);
//                view.findViewById(R.id.item_swipe_right_indicator).setAlpha(scrollProgressPercent < 0 ? -scrollProgressPercent : 0);
//                view.findViewById(R.id.item_swipe_left_indicator).setAlpha(scrollProgressPercent > 0 ? scrollProgressPercent : 0);
            }

        });
//        connectionAdapter.loadMemes(getContext(), view, cardAdapter);
        connectionAdapter.loadMemes(view, memeList, cardAdapter);
        // Inflate the layout for this fragment
        return view;
    }

}
