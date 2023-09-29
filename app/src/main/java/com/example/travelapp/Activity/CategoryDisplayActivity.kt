package com.example.travelapp.Activity

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.travelapp.R
import com.example.travelapp.databinding.ActivityCategoryDisplayBinding

class CategoryDisplayActivity : AppCompatActivity() {

    lateinit var binding: ActivityCategoryDisplayBinding
    lateinit var data: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryDisplayBinding.inflate(layoutInflater)
        setContentView(binding.root)


        initview()
    }

    private fun initview() {
        if (intent != null) {


            var key = intent.getStringExtra("key").toString()
            var Location = intent.getStringExtra("Location").toString()
            var place = intent.getStringExtra("place").toString()
            var Rate = intent.getStringExtra("Rate").toString()
            var img = intent.getStringExtra("img").toString()
            var Book_beach = intent.getStringExtra("Book_beach").toString()

            binding.txtplace.text = place
            binding.txtLocation.text = Location
            binding.txtRate.text = Rate

            Glide.with(baseContext).load(img).into(binding.imgBeach)


        }
    }
}