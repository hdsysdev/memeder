package com.hdstudio.memeder.ui.memecard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hdstudio.memeder.R

import com.hdstudio.memeder.databinding.FragmentMemeCardBinding
import com.yuyakaido.android.cardstackview.CardStackLayoutManager

class MemeCardFragment : Fragment() {

    private lateinit var viewModel: MemeCardViewModel
    private lateinit var binding: FragmentMemeCardBinding


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {


//        val root = inflater.inflate(R.layout.fragment_meme_card, container, false)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_meme_card,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner


//        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel =
            ViewModelProviders.of(this).get(MemeCardViewModel::class.java)

        val layoutManager = CardStackLayoutManager(context)

        binding.cardStackView.layoutManager = layoutManager

        binding.cardStackView.adapter = MemeCardAdapter(viewModel = viewModel)

        viewModel.memeList.observe(viewLifecycleOwner,
            Observer {

                (binding.cardStackView.adapter as MemeCardAdapter).notifyDataSetChanged()
            })

        binding.viewModel = viewModel
    }
}
