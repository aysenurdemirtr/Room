package com.example.room.data.entitys.people

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.room.data.models.people.ApiResponse
import com.example.room.data.models.people.PeopleService
import javax.inject.Inject

class PeopleRepository @Inject constructor(
    private val peopleDao : PeopleDao,
    private val peopleService : PeopleService
) {
    val getAllPeople : LiveData<List<People>> = peopleDao.getAllPeople()


    // API'den verileri çekip veritabanına kaydet
    suspend fun fetchAndInsertPeopleFromApi(errorClicked : Boolean, apiResponseResultLiveData : MutableLiveData<ApiResponse>) {

        val response = peopleService.getApiResponse()
        response.body()?.let { apiResponse ->
            // People verilerini işleme ve kaydetme

            if (errorClicked.not()) {

                peopleDao.insertPeopleList(apiResponse.data!!)

            } else {

                //hata durumu
            }

            apiResponseResultLiveData.postValue(apiResponse)

//            apiResponse.data?.let { peopleItems : List<People> ->
//
//                peopleDao.insertPeopleList(peopleItems)
//            }
//
//            apiResponseResultLiveData.postValue(apiResponse)

//            // Error verisini ekranda gösterme
//            apiResponse.error?.let { error ->
//                val errorCode = error.code
//                val errorMessage = error.message
//                errorLiveData.postValue(Pair(errorCode, errorMessage) as Pair<Int, String>?) // Hata bilgilerini ViewModel'e gönder
//            }
        }
    }


    // Veritabanındaki tüm kayıtları sil
    suspend fun deleteAllPeople() {
        peopleDao.deleteAllPeople()
    }
}
