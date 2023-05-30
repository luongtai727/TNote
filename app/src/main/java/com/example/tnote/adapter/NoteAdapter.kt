package com.example.tnote.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tnote.R
import com.example.tnote.model.Note

class NoteAdapter(private var notes: MutableList<Note>,
                  val onItemClickListener: (Note) -> Unit) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setData(notes: MutableList<Note>){
        this.notes = notes
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView
        val tvContent: TextView

        init {
            tvTitle = view.findViewById(R.id.tv_item_note_title)
            tvContent = view.findViewById(R.id.tv_item_note_content)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_note, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = notes[position].title
        holder.tvContent.text = notes[position].content

        holder.itemView.setOnClickListener{
            onItemClickListener(notes[position])
        }
    }

    override fun getItemCount(): Int = notes.size
}