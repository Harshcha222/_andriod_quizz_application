package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityResultscreenBinding
import com.example.myapplication.databinding.ActivitySpalshScrennBinding

class resultscreen : AppCompatActivity() {

    lateinit var binding: ActivityResultscreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResultscreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
         val scores= intent.getIntExtra("scoreee",0)
        binding.score.text="your score:$scores"





    }
}