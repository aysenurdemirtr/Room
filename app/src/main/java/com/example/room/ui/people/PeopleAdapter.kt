package com.example.room.ui.people

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.data.entitys.people.People

class PeopleAdapter(private var people: List<People>) :
    RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    class PeopleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idText : TextView = itemView.findViewById(R.id.id_text)
        val nameText: TextView = itemView.findViewById(R.id.name_text)
        val surnameText: TextView = itemView.findViewById(R.id.surname_text)
        val ageText: TextView = itemView.findViewById(R.id.age_text)
        val genderText: TextView = itemView.findViewById(R.id.gender_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.people_item, parent, false)
        return PeopleViewHolder(view)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = people[position]
        holder.idText.text = "ID : ${person.id.toString()}"
        holder.nameText.text = "NAME : ${person.name}"
        holder.surnameText.text = "SURNAME : ${person.surname}"
        holder.ageText.text ="AGE : ${person.age?.toString() ?: "Unknown"}"
        holder.genderText.text = "GENDER: : ${person.gender.name}"
    }

    override fun getItemCount(): Int {
        return people.size
    }

    fun setPeople(people: List<People>) {
        this.people = people
        notifyDataSetChanged()
    }
}
