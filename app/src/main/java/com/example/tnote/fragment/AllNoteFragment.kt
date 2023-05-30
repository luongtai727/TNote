package com.example.tnote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tnote.R
import com.example.tnote.adapter.NoteAdapter
import com.example.tnote.model.Note

class AllNoteFragment : Fragment() {
    private lateinit var rcvNote: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private val notes: MutableList<Note> = mutableListOf()
    private lateinit var layoutNoteEmpty: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        setUpAdapter()
        checkNotesEmpty()
    }

    private fun initView(view: View) {
        layoutNoteEmpty = view.findViewById(R.id.layout_note_empty)
        rcvNote = view.findViewById(R.id.rcv_note)
    }

    private fun checkNotesEmpty() {
        if (notes.isEmpty()){
            hideRecyclerViewNote()
        }else{
            showRecyclerViewNote()
        }
    }

    private fun hideRecyclerViewNote() {
        rcvNote.visibility = View.GONE
        layoutNoteEmpty.visibility = View.VISIBLE
    }

    private fun showRecyclerViewNote() {
        rcvNote.visibility = View.VISIBLE
        layoutNoteEmpty.visibility = View.GONE
    }

    private fun setUpAdapter() {
        noteAdapter = NoteAdapter(notes)
        rcvNote.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }
}