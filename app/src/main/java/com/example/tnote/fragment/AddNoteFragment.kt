package com.example.tnote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.tnote.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class AddNoteFragment : Fragment() {

    private lateinit var edtTitle: EditText
    private lateinit var edtContent: EditText
    private lateinit var btnAddNote: ExtendedFloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_note, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        initEvents()
    }

    private fun initView(view: View) {
        edtTitle = view.findViewById(R.id.edt_add_note_title)
        edtContent = view.findViewById(R.id.edt_add_note_content)
        btnAddNote = view.findViewById(R.id.save_fab)
    }

    private fun initEvents() {
        btnAddNote.setOnClickListener {
            passResulToTheAllNoteFragment()
        }
    }

    private fun passResulToTheAllNoteFragment() {
        setFragmentResult(
            AllNoteFragment.REQUEST_KEY, bundleOf(
                "title" to edtTitle.text.toString(),
                "content" to edtContent.text.toString()
            )
        )
        parentFragmentManager.popBackStack()
    }
}