package com.aghamiri.dictionary.utils

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun logi(message: String) {
    Log.i("tag", message)
}
fun logd(message: String) {
    Log.d("tag", message)
}

fun logw(message: String) {
    Log.w("tag", message)
}

fun loge(message: String) {
    Log.e("tag", message)
}

fun RecyclerView.setVerticalLayout(){
    this.layoutManager = LinearLayoutManager(context)
}