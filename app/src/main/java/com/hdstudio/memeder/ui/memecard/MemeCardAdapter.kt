package com.hdstudio.memeder.ui.memecard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hdstudio.memeder.data.model.MemeCard
import com.hdstudio.memeder.databinding.CardViewBinding
import com.hdstudio.memeder.databinding.FragmentMemeCardBinding

class MemeCardAdapter(
    private val viewModel: MemeCardViewModel
) : RecyclerView.Adapter<MemeCardAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentMemeCardBinding.inflate(inflater)

        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(viewModel.memeList.)
    }

    override fun getItemCount(): Int = viewModel.memeList.observe()


    fun setMemeList(memeList: ArrayList<MemeCard>){

    }



    class ViewHolder(
        private val binding: FragmentMemeCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(memeCard: MemeCard) {

            binding.memeCard = memeCard

            binding.executePendingBindings()
        }
    }
}