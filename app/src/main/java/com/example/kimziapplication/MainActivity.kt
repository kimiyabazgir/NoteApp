package com.example.kimziapplication


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kimziapplication.databinding.ActivityMainBinding
import com.example.kimziapplication.di.qualifire.SiteName
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject
    @SiteName
    lateinit var userName:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            infoTxt.text=userName
        }

    }
}