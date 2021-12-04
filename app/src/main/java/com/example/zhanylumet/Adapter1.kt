package com.example.zhanylumet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView


class Adapter1(var contact: List<Contacts>, private val click: (contacts: Contacts) -> Unit): RecyclerView.Adapter<Adapter1.ViewHolder>() {

    fun setData(contact: List<Contacts>) {
        this.contact = contact
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(view, click)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = contact[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return contact.size
    }

    class ViewHolder(itemView: View, private val click: (contacts: Contacts) -> Unit): RecyclerView.ViewHolder(itemView) {

        fun bind(item: Contacts) {
            val name = itemView.findViewById<AppCompatTextView>(R.id.itemName)
            val btn = itemView.findViewById<AppCompatButton>(R.id.itemBtn)
            name.text = item.name
            btn.setOnClickListener {
                click.invoke(item)
            }
        }
    }
}