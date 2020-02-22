package com.aghamiri.dictionary.data

import androidx.room.Dao
import androidx.room.Query
import com.aghamiri.dictionary.data.entities.Word

@Dao
interface WordDao {

    @Query("SELECT * FROM words")
    fun getAll(): List<Word>


    @Query("SELECT * FROM words  WHERE enWord  LIKE '%' || :title || '%' OR faWord  LIKE '%' || :title || '%'")
    fun search(title: String): List<Word>


}