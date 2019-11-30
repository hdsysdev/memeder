package com.hdstudio.memeder.ui.memecard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders

import com.hdstudio.memeder.databinding.FragmentMemeCardBinding
import com.yuyakaido.android.cardstackview.CardStackLayoutManager

class MemeCardFragment : Fragment() {

    private lateinit var memeCardViewModel: MemeCardViewModel
    private lateinit var memeCardBinding: FragmentMemeCardBinding
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        memeCardViewModel =
                ViewModelProviders.of(this).get(MemeCardViewModel::class.java)

//        val root = inflater.inflate(R.layout.fragment_meme_card, container, false)
        memeCardBinding = FragmentMemeCardBinding.inflate(inflater)


        memeCardBinding.cardStackView.layoutManager = CardStackLayoutManager(context)

//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return memeCardBinding.root
    }
}
