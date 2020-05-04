package com.github.kiolk.allmed.presentation.screen.doctor

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.kiolk.allmed.R
import com.github.kiolk.allmed.presentation.adapter.symptoms.SymptomsAdapter
import com.github.kiolk.allmed.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_doctor.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class DoctorFragment : BaseFragment<DoctorViewModel>() {

    override val viewModel: DoctorViewModel by viewModel()

    private lateinit var adapter: SymptomsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doctor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = SymptomsAdapter()
        rv_symptoms.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv_symptoms.hasFixedSize()
        rv_symptoms.adapter = adapter

        iv_search_icon.setOnClickListener {
            stubDialog()
        }

        iv_voice_search.setOnClickListener {
            stubDialog()
        }

        btn_skip_symptom.setOnClickListener {
            stubDialog()
        }

        btn_next_symptom.setOnClickListener {
            stubDialog()
        }

        et_search.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    stubDialog()
                    return true
                }
                return false
            }
        })
    }
}
