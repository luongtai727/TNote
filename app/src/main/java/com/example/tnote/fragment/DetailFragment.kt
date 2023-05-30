package com.example.tnote.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.tnote.R
import java.text.SimpleDateFormat
import java.util.*

class DetailFragment : Fragment() {
    lateinit var tvTitle: TextView
    lateinit var tvContent: TextView
    lateinit var tvTimeCreate: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        initView(view)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tvTitle.text = getArguments()?.getString("title")
        tvContent.text = getArguments()?.getString("content")
        tvTimeCreate.text = getArguments()?.let { convertTimestampToFormattedDate(it.getLong("time")) }
    }


    private fun initView(view: View) {
        tvTitle = view.findViewById(R.id.tv_detail_title)
        tvContent = view.findViewById(R.id.tv_detail_content)
        tvTimeCreate = view.findViewById(R.id.tv_detail_time_create)
    }


    fun convertTimestampToFormattedDate(timestamp: Long): String {
        val date = Date(timestamp)
        val format = SimpleDateFormat("dd 'tháng' MM 'năm' yyyy, h:mm a", Locale("vi", "VN"))
        return format.format(date)
    }
}