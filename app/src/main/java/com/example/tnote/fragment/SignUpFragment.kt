package com.example.tnote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.commit
import com.example.tnote.R

class SignUpFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initEvents(view)
    }

    private fun initEvents(view: View) {
        initEventBack(view)
        initEventSignup(view)
    }

    private fun initEventBack(view: View) {
        view.findViewById<ImageView>(R.id.img_signup_back).setOnClickListener{
            backToSignInFragment()
        }
    }

    private fun initEventSignup(view: View) {
        view.findViewById<Button>(R.id.btn_signup).setOnClickListener{
            backToSignInFragment()
        }
    }

    private fun backToSignInFragment() {
        parentFragmentManager.commit {
            remove(this@SignUpFragment)
        }
    }
}