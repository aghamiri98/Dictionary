package com.aghamiri.dictionary.data

import android.app.Application
import com.aghamiri.dictionary.data.entities.Word


class DataRepository(application: Application) {

    private var db: DatabaseCopier? = null
    private var dataDao: WordDao? = null

    init {
        db = DatabaseCopier.getInstance(application)
        dataDao = db!!.roomDatabase.wordDao()
    }


    fun getAll(): List<Word> {
        return dataDao!!.getAll()
    }
   fun search(title: String): List<Word> {
        return dataDao!!.search(title)
    }


}