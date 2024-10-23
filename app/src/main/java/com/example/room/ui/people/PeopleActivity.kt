package com.example.room.ui.people

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.entitys.people.PeopleRepository
import com.example.room.data.models.people.ApiResponse
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PeopleActivity : AppCompatActivity() {

    private lateinit var viewModel : PeopleViewModel
    private lateinit var peopleAdapter : PeopleAdapter

    @Inject
    lateinit var repository : PeopleRepository // Hilt ile sağlanan repository

    lateinit var recyclerView : RecyclerView
    lateinit var kayitYok_text : TextView
    lateinit var data_btn : Button
    lateinit var delete_btn : Button
    lateinit var error_btn : Button

    private lateinit var progressDialog : ProgressDialog

    private var showError = false

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.people_activity)

        recyclerView = findViewById<RecyclerView>(R.id.people_recyclerView)
        kayitYok_text = findViewById<TextView>(R.id.kayitYok_text)
        data_btn = findViewById<Button>(R.id.data_btn)
        delete_btn = findViewById<Button>(R.id.delete_btn)
        error_btn = findViewById<Button>(R.id.error_btn)


        // ViewModel initialization
        viewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
        peopleAdapter = PeopleAdapter(listOf())
        recyclerView.adapter = peopleAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        progressDialog = getDefaultProgressDialog()

        setObservables()

        setViewListener()
    }

    @Suppress("DEPRECATION")
    fun getDefaultProgressDialog() : ProgressDialog {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("LÜTFEN BEKLEYİNİZ")
        progressDialog.setCancelable(true)
        progressDialog.setCanceledOnTouchOutside(false)
        return progressDialog
    }

    private fun setObservables() {

        viewModel.peopleDatabaseLiveData.observe(this) {

            if (it.isEmpty()) {

                kayitYok_text.visibility = View.VISIBLE

            } else {

                kayitYok_text.visibility = View.GONE
            }

            peopleAdapter.setPeople(it)
        }

        viewModel.apiResponseResultLiveData.observe(this) { apiResponse : ApiResponse ->

            progressDialog.dismiss()

            if (showError) {

                apiResponse.error?.let { error ->

                    showErrorDialog(error.code, error.message)
                }

                showError = false
            }
        }
    }

    private fun setViewListener() {

        error_btn.setOnClickListener {

            showError = true

            viewModel.fetchAndInsertPeople(true)
        }

        // Data butonuna tıklayınca verileri çek ve veritabanına kaydet
        data_btn.setOnClickListener {

            progressDialog.show()

            viewModel.fetchAndInsertPeople()
        }

        // Delete butonuna tıklayınca veritabanındaki tüm verileri sil
        delete_btn.setOnClickListener {
            viewModel.deleteAllPeople()
        }
    }


    private fun showErrorDialog(errorCode : Int, errorMessage : String) {
        AlertDialog.Builder(this)
            .setTitle("Hata kodu : $errorCode")
            .setMessage(errorMessage)
            .setPositiveButton("Tamam") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}