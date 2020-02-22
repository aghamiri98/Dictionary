package com.aghamiri.dictionary.data.entities
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "words")
data class Word(
    @SerializedName("enWord")
    var enWord: String?,
    @SerializedName("faWord")
    var faWord: String?,
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Int
)