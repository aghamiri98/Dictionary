package com.aghamiri.dictionary.data

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.aghamiri.dictionary.data.entities.Word


class WordViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: DataRepository? = null
    var datas = MutableLiveData<List<Word>>()

    init {
        repository = DataRepository(application)
    }


    fun getAll() {
        GetDataTask(repository!!).execute("all", "")
    }


    fun search(title: String) {
        GetDataTask(repository!!).execute("search", title)
    }


    @SuppressLint("StaticFieldLeak")
    inner class GetDataTask(private val repository: DataRepository) :
        AsyncTask<String, String, List<Word>>() {

        override fun doInBackground(vararg params: String): List<Word>? {
            val type = params[0]
            val word = params[1]
            if (type == "all") {
                return repository.getAll()
            } else if (type == "search") {
                return repository.search(word)
            }
            return null
        }

        override fun onPostExecute(data: List<Word>) {
            super.onPostExecute(data)
            //datas.postValue(data) //change LiveData value
            datas.value = data //change LiveData value
        }
    }


}