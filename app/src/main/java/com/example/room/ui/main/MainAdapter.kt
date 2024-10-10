package com.example.room.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.entitys.person.Person

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private var personList = emptyList<Person>()

    class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idText: TextView = itemView.findViewById(R.id.id_text)
        val nameText: TextView = itemView.findViewById(R.id.name_text)
        val ageText: TextView = itemView.findViewById(R.id.age_text)
        val sexText: TextView = itemView.findViewById(R.id.sex_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.main_item, parent, false)
        return PersonViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currentItem = personList[position]
        holder.idText.text = currentItem.id.toString()
        holder.nameText.text = currentItem.name
        holder.ageText.text = currentItem.age.toString()
        holder.sexText.text = if (currentItem.sex) "Male" else "Female"
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    fun setData(persons: List<Person>) {
        this.personList = persons
        notifyDataSetChanged()
        Log.d("MainActivity", "People Listed")
    }
}

