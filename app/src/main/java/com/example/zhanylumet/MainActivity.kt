package com.example.zhanylumet

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.zhanylumet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnFragmentClick {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.fragmentContainer
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, Fragment1())
            .commit()
    }

    override fun onClicked(contacts: Contacts) {
        super.onClicked(contacts)
        val fragment2 = Fragment2()

        val bundle = Bundle()
        bundle.putString("name", contacts.name)
        bundle.putString("number", contacts.number)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}