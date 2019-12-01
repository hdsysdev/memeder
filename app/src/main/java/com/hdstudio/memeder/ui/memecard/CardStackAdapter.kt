package com.hdstudio.memeder.ui.memecard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hdstudio.memeder.data.model.Meme
import com.hdstudio.memeder.databinding.CardViewBinding

class CardStackAdapter(
    private var mMemeList: List<Meme> = emptyList()

) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardViewBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return mMemeList.size
    }

    fun setMemeList(memeList: List<Meme>){
        this.mMemeList = memeList
    }

    fun getMemeList(): List<Meme>{return mMemeList}

    class ViewHolder(
        private val binding: CardViewBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(meme: Meme) {
            binding.cardTextView.text = meme.postedBy
            binding.cardScoreTextView.text = meme.rating.toString()
//          TODO: ADD IMAGE FILLING FROM REPOSITORY
            binding.executePendingBindings()
        }
    }
}