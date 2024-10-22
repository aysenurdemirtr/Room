package com.example.room.data.models.album

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// Bu yapı, Retrofit kullanarak API isteklerini yapmak için gerekli olan ayarları sağlar ve
// her seferinde Retrofit nesnesini oluşturmak yerine, merkezi bir yerden bu nesneye erişim sağlar.
// API ile iletişim kurmak istediğinizde, RetrofitInstance.getRetrofitInstance()
// fonksiyonunu çağırarak bu nesneyi alabilir ve
// ilgili servis sınıfı (AlbumService gibi) ile istekleri yapabilirsiniz.


object RetrofitInstance {
        val mainURL = "https://jsonplaceholder.typicode.com"

        fun getRetrofitInstance(): Retrofit{
            return Retrofit.Builder()
                .baseUrl(mainURL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build()
        }

}

// Aslında, companion object kullanarak yaptığınız yapı, tam anlamıyla bir singleton değildir,
// ancak Kotlin'de companion object'ler doğal olarak singleton davranışı gösterir.
// Yani her sınıfın sadece bir tane companion object örneği vardır
// ve sınıfa ait bu companion object'e her yerden erişilebilir.
// Bu da bir singleton davranışını taklit eder.
// object diyerek ben singelton yapabilirim bu sınıfı. kotlinin özelliği