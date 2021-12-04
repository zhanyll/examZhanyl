package com.example.zhanylumet

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.example.zhanylumet.databinding.Fragment2Binding

class Fragment2: Fragment(R.layout.fragment_2) {
    private var _binding: Fragment2Binding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment2Binding.bind(view)
        binding.apply {
            val name = txt1
            val name1 = arguments?.getString("name")
            val number = txt2
            val number1 = arguments?.getString("number")
            name.text = "$name1"
            number.text = "$number1"
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}