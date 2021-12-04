package com.example.zhanylumet

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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


        when(intent.action) {
            "contactApp" -> {
                val extra = intent.getStringExtra("key")
                Toast.makeText(this, "This is $extra!", Toast.LENGTH_SHORT).show()
            }
            else -> {
                Toast.makeText(this, "Wrong action!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onClicked(contacts: Contacts) {
        super.onClicked(contacts)
        val fragment2 = Fragment2()

        val bundle = Bundle()
        bundle.putString("name", contacts.name)
        bundle.putString("number", contacts.number)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, fragment2)
            .addToBackStack(null)
            .commit()
    }
}