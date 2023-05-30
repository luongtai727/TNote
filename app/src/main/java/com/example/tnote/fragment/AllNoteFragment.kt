package com.example.tnote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tnote.R
import com.example.tnote.adapter.NoteAdapter
import com.example.tnote.model.Note
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AllNoteFragment : Fragment() {
    private lateinit var rcvNote: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private val notes: MutableList<Note> = mutableListOf()
    private lateinit var layoutNoteEmpty: View
    private lateinit var btnAddNote: FloatingActionButton

    companion object{
        const val REQUEST_KEY = "Add_fragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_all_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        initEvents()
        setUpAdapter()
        checkNotesEmpty()
        listenResultFromAddFragment()
    }

    private fun initView(view: View) {
        layoutNoteEmpty = view.findViewById(R.id.layout_note_empty)
        rcvNote = view.findViewById(R.id.rcv_note)
        btnAddNote = view.findViewById(R.id.btn_all_note_add_note)
    }

    private fun initEvents() {
        btnAddNote.setOnClickListener {
            goToAddNoteFragment()
        }
    }

    private fun goToAddNoteFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<AddNoteFragment>(R.id.container_view)
            addToBackStack(null)
        }
    }

    private fun setUpAdapter() {
        noteAdapter = NoteAdapter(notes)
        rcvNote.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun checkNotesEmpty() {
        if (notes.isEmpty()) {
            hideRecyclerViewNote()
        } else {
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

    private fun listenResultFromAddFragment() {
        setFragmentResultListener(REQUEST_KEY) {_, result->
            val title = result.getString("title")
            val content = result.getString("content")

            notes.add(Note(title!!, content!!))
            noteAdapter.setData(notes)
            checkNotesEmpty()
        }
    }
}