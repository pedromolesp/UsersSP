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

        setContentView(binding.root)
        userAdapter = UserAdapter(getUsers())
        linearLayoutManager = LinearLayoutManager(this)
        binding.recycler.apply {
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }

    }

    private fun getUsers():MutableList<User>{
        val users = mutableListOf<User>()

        val alain = User(1,"Alain","Nicolás","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSAcxKvNdS_m2u21A3f1eq6wnd7jBrabcfYDw&usqp=CAU")
        val samanta = User(2,"Samanta","Peña","https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg")
        val julian = User(2,"Julián","Peña","https://img.huffingtonpost.com/asset/5e59a34c230000590d39c782.jpeg?cache=DIia6XM8wX&ops=scalefit_720_noupscale")
        val enma = User(2,"Enma","Peña","https://img.huffingtonpost.com/asset/5f063bac1f00003d07337b92.jpeg?ops=1778_1000")
        users.add(alain)
        users.add(julian)
        users.add(enma)
        users.add(samanta)
        users.add(alain)
        users.add(julian)
        users.add(enma)
        users.add(samanta)
        users.add(alain)
        users.add(julian)
        users.add(enma)
        users.add(samanta)
        return users
    }
}