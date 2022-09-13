package com.example.moto_app

import android.content.Context
import com.example.moto_app.ModelPerson
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.moto_app.R
import com.squareup.picasso.Picasso
import android.widget.TextView
import android.widget.Toast

class AdapterPerson(private val modelPersonList: List<ModelPerson>, private val context: Context) :
    RecyclerView.Adapter<AdapterPerson.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_person_list, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val modelPerson = modelPersonList[position]
        holder.tvName.text = modelPerson.personName
        holder.tvEmail.text = modelPerson.personEmail
        Picasso.get().load(modelPerson.personProfile).into(holder.ivPersonImage)

        // implementation 'com.squareup.picasso:picasso:2.71828'
    }

    override fun getItemCount(): Int {
        return modelPersonList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        val tvName: TextView
        val tvEmail: TextView
         val ivPersonImage: ImageView
        override fun onClick(v: View) {
            val modelPerson = modelPersonList[adapterPosition]
            Toast.makeText(context, modelPerson.personName, Toast.LENGTH_SHORT).show()
        }

        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvEmail = itemView.findViewById(R.id.tvEmail)
            ivPersonImage = itemView.findViewById(R.id.ivPersonImage)
            itemView.setOnClickListener(this)
        }
    }
}