package com.hdstudio.memeder.ui.memecard

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hdstudio.memeder.data.model.MemeCard
import com.hdstudio.memeder.databinding.FragmentMemeCardBinding

class MemeCardAdapter(private var memeList: ArrayList<MemeCard>) : RecyclerView.Adapter<MemeCardAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return parent
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setMemeList(memeList: ArrayList<MemeCard>){

    }

    class ViewHolder(val binding: FragmentMemeCardBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(memeCardViewModel: MemeCardViewModel) {
            binding.memeCard = memeCardViewModel
            binding.executePendingBindings()
        }
    }
}