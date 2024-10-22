package com.example.room.ui.people

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.entitys.people.PeopleRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class PeopleActivity : AppCompatActivity() {

    private lateinit var viewModel: PeopleViewModel
    private lateinit var peopleAdapter: PeopleAdapter

    @Inject
    lateinit var repository: PeopleRepository // Hilt ile sağlanan repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.people_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.people_recyclerView)
        val kayitYok_text = findViewById<TextView>(R.id.kayitYok_text)
        val data_btn = findViewById<Button>(R.id.data_btn)
        val delete_btn = findViewById<Button>(R.id.delete_btn)
        val error_btn = findViewById<Button>(R.id.error_btn)

        // ViewModel initialization
        viewModel = ViewModelProvider(this).get(PeopleViewModel::class.java)
        peopleAdapter = PeopleAdapter(listOf())
        recyclerView.adapter = peopleAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        error_btn.setOnClickListener{
            viewModel.errorData.observe(this, { error ->
                error?.let {
                    val errorCode = it.first
                    val errorMessage = it.second
                    showErrorDialog(errorCode, errorMessage)
                }

            })
        }

        // Data butonuna tıklayınca verileri çek ve veritabanına kaydet
        data_btn.setOnClickListener {
            viewModel.fetchAndInsertPeople()
        }

        // Delete butonuna tıklayınca veritabanındaki tüm verileri sil
        delete_btn.setOnClickListener {
            viewModel.deleteAllPeople()
        }


        // Verileri ekranda göster (RecyclerView ile)
        viewModel.allPeople.observe(this, Observer { peopleList ->
            if (peopleList.isEmpty()) {
                kayitYok_text.visibility = View.VISIBLE
                recyclerView.visibility = View.GONE
            } else {
                kayitYok_text.visibility = View.GONE
                recyclerView.visibility = View.VISIBLE
                // RecyclerView'a verileri bağla
                peopleAdapter.setPeople(peopleList)
            }
        })
    }

    private fun showErrorDialog(errorCode: Int, errorMessage: String) {
        AlertDialog.Builder(this)
            .setTitle("Hata kodu : $errorCode")
            .setMessage(errorMessage)
            .setPositiveButton("Tamam") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}