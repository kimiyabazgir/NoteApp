package com.example.noteApp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kimziapplication.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Named


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Named("NAMED_APP_INFO")
    private lateinit var userName:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            infoTxt.text=userName
        }

    }
}