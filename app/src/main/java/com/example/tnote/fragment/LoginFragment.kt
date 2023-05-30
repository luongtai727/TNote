package com.example.tnote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.tnote.R
import com.google.android.material.textview.MaterialTextView


class LoginFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initEvents(view)
    }

    private fun initEvents(view: View) {
        initEventSignup(view)
    }

    private fun initEventSignup(view: View) {
        view.findViewById<MaterialTextView>(R.id.tv_login_title_sign_up).setOnClickListener {
            goToSignUpFragment()
        }
    }

    private fun goToSignUpFragment() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<SignUpFragment>(R.id.container_view)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
}