package com.example.zhanylumet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.zhanylumet.databinding.Fragment1Binding

class Fragment1: Fragment(R.layout.fragment_1) {
    private lateinit var listener: OnFragmentClick
    private var _binding: Fragment1Binding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listener = context as OnFragmentClick
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = Fragment1Binding.bind(view)

        var contactList = mutableListOf(
            Contacts("masha", "0990765456"),
            Contacts("sasha", "0555654533"),
            Contacts("aydana", "0777672112"),
            Contacts("aydar", "0706889455"),
            Contacts("alina", "0778634568")
        )

        val adapter = Adapter1(contactList) {
            listener.onClicked(it)
        }

        val recycler = binding.recycler
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(activity)
        recycler.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

        binding.btn.setOnClickListener {
            val name = binding.editName.text.toString()
            val number = binding.editNumber.text.toString()

            if (!(name == "" || number == "")) {
                val new: Contacts = Contacts(name, number)
                contactList.add(new)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(requireContext(), "Enter name and number!!!", Toast.LENGTH_SHORT).show()
            }

            binding.editName.text = null
            binding.editNumber.text = null
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}