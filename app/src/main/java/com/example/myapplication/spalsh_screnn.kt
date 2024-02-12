package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivitySpalshScrennBinding

class spalsh_screnn : AppCompatActivity() {

    lateinit var binding: ActivitySpalshScrennBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpalshScrennBinding.inflate(layoutInflater)
        setContentView(binding.root)

binding.start.setOnClickListener{

val intent= Intent(this,MainActivity::class.java)

    startActivity(intent)

}


    }
}