package com.example.userssp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userssp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)
        userAdapter = UserAdapter(mutableListOf())
        linearLayoutManager = LinearLayoutManager(this)
        binding.recycler.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }

    }
}