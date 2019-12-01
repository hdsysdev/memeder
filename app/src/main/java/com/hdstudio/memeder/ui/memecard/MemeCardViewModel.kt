package com.hdstudio.memeder.ui.memecard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hdstudio.memeder.data.model.Meme
import com.hdstudio.memeder.data.model.MemeCard

class MemeCardViewModel : ViewModel() {

    private val mMemeList = MutableLiveData<ArrayList<MemeCard>>().apply {
        val fakeCard = MemeCard(
            Meme(
                id = "Jeff21",
                imageName = "meme.jpg",
                postedBy = "Nobody",
                rating = 0,
                num = 0
            ))
        val fakeList = ArrayList<MemeCard>()
        fakeList.add(fakeCard)
        value = fakeList
    }

    val memeList: LiveData<ArrayList<MemeCard>> = mMemeList
//    private val _text = MutableLiveData<String>().apply {
//        value = "This is dashboard Fragment"
//    }
//    val text: LiveData<String> = _text
}