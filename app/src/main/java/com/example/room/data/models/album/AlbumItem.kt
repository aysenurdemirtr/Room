package com.example.room.data.models.album

import com.google.gson.annotations.SerializedName


//@SerializedName , JSON'dan gelen başlıklardan farklı olarak
// isimlendirme yapmak istersem bunu anotasyonu kullanıyorum.

data class AlbumItem(
    @SerializedName("id")
    val id : Int,

    @SerializedName("userId")
    val userId : Int,

    @SerializedName("title")
    val title: String
)
