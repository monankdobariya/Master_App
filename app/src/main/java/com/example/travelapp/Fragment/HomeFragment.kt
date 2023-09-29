package com.example.travelapp.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.travelapp.Activity.CategorieActivity
import com.example.travelapp.Activity.MostVisitedActivity
import com.example.travelapp.Adapter.AdapterClass
import com.example.travelapp.Adapter.FavouriteAdapter
import com.example.travelapp.Adapter.ImageAdapter
import com.example.travelapp.ModelClass.StudentModelClass
import com.example.travelapp.R
import com.example.travelapp.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.ktx.Firebase


class HomeFragment : Fragment() {


    private var Binding: FragmentHomeBinding? = null
    private lateinit var auth: FirebaseAuth
    lateinit var firebaseDatabase: DatabaseReference
    private val binding get() = Binding
    var list = arrayListOf<Int>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding?.root


        firebaseDatabase = FirebaseDatabase.getInstance().getReference()
        auth = Firebase.auth


        Admin()
        initview()
        return view
    }

    private fun Admin() {
        var refrence = FirebaseDatabase.getInstance().reference
        var list = ArrayList<StudentModelClass>()

        refrence.root.child("AdminTb").addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                for (child in snapshot.children) {
                    var data: StudentModelClass? = child.getValue(StudentModelClass::class.java)
                    if (data != null) {
                        list.add(data)
                    }
                }
                var adpter = AdapterClass(this@HomeFragment, list)
                { place: String, Location: String, Rate: String, img: String, key: String ->

                    var i = Intent(context, MostVisitedActivity::class.java)

                    i.putExtra("place", place)
                    i.putExtra("Location", Location)
                    i.putExtra("Rate", Rate)
                    i.putExtra("img", img)
                    i.putExtra("key", key)
                    startActivity(i)

                }
                var manager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                binding?.rcv?.layoutManager = manager
                binding?.rcv?.adapter = adpter
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }

    private fun initview() {
        list.add(R.drawable.viewpager_img1)
        list.add(R.drawable.viewpager_img2)
        list.add(R.drawable.viewpager_img3)
        list.add(R.drawable.viewpager_img4)

        var adapter = ImageAdapter(list)
        binding?.viewpager?.adapter = adapter

        Binding?.imgMountain?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Mountain")
            startActivity(i)
        }
        Binding?.imgBeach?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Beach")
            startActivity(i)
        }
        Binding?.imgLakes?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Lakes")
            startActivity(i)
        }
        Binding?.imgCamp?.setOnClickListener {

            var i = Intent(context, CategorieActivity::class.java)
            i.putExtra("category", "Camp")
            startActivity(i)
        }

    }
}