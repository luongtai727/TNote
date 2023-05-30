package com.example.tnote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.tnote.R
import com.google.android.material.textview.MaterialTextView

class LoginFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initEvents(view)
    }

    private fun initEvents(view: View) {
        initEventSignup(view)
        initEventLogin(view)
    }

    private fun initEventSignup(view: View) {
        view.findViewById<MaterialTextView>(R.id.tv_login_title_sign_up).setOnClickListener {
            goToSignUpFragment()
        }
    }

    private fun initEventLogin(view: View) {
        view.findViewById<Button>(R.id.btn_login).setOnClickListener {
            goToAllNoteFragment()
        }
    }

    private fun goToSignUpFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<SignUpFragment>(R.id.container_view)
        }
    }

    private fun goToAllNoteFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace<AllNoteFragment>(R.id.container_view)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}