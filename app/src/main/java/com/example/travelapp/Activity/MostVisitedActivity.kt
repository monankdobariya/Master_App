package com.example.travelapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.travelapp.Adapter.CategorieAdapter
import com.example.travelapp.R
import com.example.travelapp.databinding.ActivityCategoryDisplayBinding
import com.example.travelapp.databinding.ActivityMostVisitedBinding

class MostVisitedActivity : AppCompatActivity() {

    lateinit var binding: ActivityMostVisitedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMostVisitedBinding.inflate(layoutInflater)
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

            binding.palce.text = place
            binding.txtlocation.text = Location
            binding.txtRating.text = Rate

            Glide.with(baseContext).load(img).into(binding.img)


        }

    }
}