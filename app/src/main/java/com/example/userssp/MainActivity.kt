package com.example.userssp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.userssp.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(), OnClickListener {
    private lateinit var userAdapter: UserAdapter
    private lateinit var linearLayoutManager: RecyclerView.LayoutManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val preferences = getPreferences(Context.MODE_PRIVATE)
        val isFirstTime = preferences.getBoolean(getString(R.string.sp_first_time), true)
        Log.i("SP", "${getString(R.string.sp_first_time)} = $isFirstTime")
        if (isFirstTime) {
            val dialogView=layoutInflater.inflate(R.layout.dialog_register, null)
            MaterialAlertDialogBuilder(this).setTitle(R.string.dialog_title).setView(dialogView)
                .setPositiveButton(R.string.dialog_confirm,
                    { dialogInterface, i ->
                        val username = dialogView.findViewById<TextInputEditText>(R.id.etUsername).text.toString()

                        with(preferences.edit()){
                            putBoolean(getString(R.string.sp_first_time), false).putString(getString(R.string.sp_username),
                                username
                            ).apply()
                        }
                        preferences.edit().putBoolean(getString(R.string.sp_first_time), false)
                            .commit()

                    }).setCancelable(false)
                .show()
        }else{

        }
        userAdapter = UserAdapter(getUsers(), this)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recycler.apply {
            setHasFixedSize(true)
            layoutManager = linearLayoutManager
            adapter = userAdapter
        }

    }

    private fun getUsers(): MutableList<User> {
        val users = mutableListOf<User>()

        val alain = User(1, "Alain", "Nicolás", "https://i.blogs.es/c27813/emma-2020/1366_2000.jpg")
        val samanta = User(
            2,
            "Samanta",
            "Peña",
            "https://www.caritas.org.mx/wp-content/uploads/2019/02/cualidades-persona-humanitaria.jpg"
        )
        val julian = User(
            2,
            "Julián",
            "Peña",
            "https://img.huffingtonpost.com/asset/5e59a34c230000590d39c782.jpeg?cache=DIia6XM8wX&ops=scalefit_720_noupscale"
        )
        val enma = User(
            2,
            "Enma",
            "Peña",
            "https://img.huffingtonpost.com/asset/5f063bac1f00003d07337b92.jpeg?ops=1778_1000"
        )
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

    override fun onClick(user: User, position: Int) {
        Toast.makeText(this, "${position}: ${user.getFullName()}", Toast.LENGTH_SHORT).show()
    }
}