package com.github.kiolk.allmed.presentation.screen.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.doctor.DoctorAdapter
import com.github.kiolk.allmed.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_chat.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class ChatFragment : BaseFragment<ChatViewModel>() {

    override val viewModel: ChatViewModel by viewModel()

    private lateinit var adapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_doctor_chat.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        adapter = DoctorAdapter()
        rv_doctor_chat.adapter = adapter

        iv_search_char.setOnClickListener {
            stubDialog()
        }
    }
}
