package com.example.anchorbooks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.anchorbooks.R
import com.example.anchorbooks.databinding.ListFragmentBinding
import com.example.anchorbooks.view.ListFragment
import com.example.anchorbooks.viewModel.BooksViewModel

class MainActivity : AppCompatActivity() {

    private val mv by viewModels<BooksViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mv.booksList().observe(this,{
            Log.d("Listadovm","hasido activado en el menu y recibe ${it.size}")
        }
        )
        supportFragmentManager.beginTransaction().add(R.id.frame_main, ListFragment()).commit()
    }
}