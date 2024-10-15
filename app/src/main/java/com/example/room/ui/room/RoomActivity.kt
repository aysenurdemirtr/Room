package com.example.room.ui.room

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.entitys.person.Person
import dagger.hilt.android.AndroidEntryPoint
import kotlin.random.Random


@AndroidEntryPoint
class RoomActivity : AppCompatActivity() {

    // @Inject lateinit var testHelpers: TestHelpers

    private lateinit var personAdapter: PersonAdapter
    private val personViewModel: RoomViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.room_activity)

        // RecyclerView setup
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        personAdapter = PersonAdapter()
        recyclerView.adapter = personAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // LiveData gözlemi
        personViewModel.readAllData.observe(this, Observer { personList ->
            personAdapter.setData(personList)
        })

        buttonListener()
    }
    private fun buttonListener(){
        // CREATE butonuna tıklama olayını ayarla
        val createButton: Button = findViewById(R.id.create_btn)
        createButton.setOnClickListener {
            createRandomPerson()
        }
        val readButton: Button = findViewById(R.id.read_btn)
        readButton.setOnClickListener {
            readPersons()
        }

        val updateButton: Button = findViewById(R.id.update_btn)
        updateButton.setOnClickListener {
            // Örnek: Güncellenmek istenen kişinin ID'sini ve yeni bilgilerini alarak güncelleme yapın.
            val personToUpdate = Person(id = 48, name = "New Name", age = 25, sex = true)
            personViewModel.updatePerson(personToUpdate)
        }

        // DELETE butonuna tıklama olayını ayarla
        val deleteButton: Button = findViewById(R.id.delete_btn)
        deleteButton.setOnClickListener {
            deleteSingleCharacterIdPersons()
        }
    }
    private fun createRandomPerson() {
        // Random değerler oluştur
        val name = "Name " + System.currentTimeMillis()
        val age = Random.nextInt(100) + 1 // 1 ile 100 arasında yaş
        val sex = Random.nextInt(2) == 0 // true veya false

        // Yeni Person nesnesini ekle
        val person = Person(0, name, age, sex)
        personViewModel.addPerson(person)
        Log.d("MainActivity", "Person added: Name: $name, Age: $age, Sex: $sex")
    }
    private fun readPersons() {
        // LiveData gözlemi
        personViewModel.readAllData.observe(this, Observer { persons ->
            // Verileri ekranda göster
            personAdapter.setData(persons)
            Log.d("MainActivity", "People Listed") // Gözlemden gelen veriyi gösterir
        })
    }
    private fun deleteSingleCharacterIdPersons() {
        personViewModel.deleteLastNPersons(3)
    }
}
