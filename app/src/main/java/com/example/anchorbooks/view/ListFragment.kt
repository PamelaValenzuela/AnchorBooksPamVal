package com.example.anchorbooks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.anchorbooks.databinding.ListFragmentBinding
import com.example.anchorbooks.viewModel.BooksViewModel


class ListFragment :Fragment() {

    private lateinit var binding: ListFragmentBinding

    private val mv by activityViewModels<BooksViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding= ListFragmentBinding.inflate(layoutInflater)
     //  binding.rvList.layoutManager = LinearLayout(context)



        val adapter= ListAdapter()
        binding.rvList.adapter = adapter

      mv.booksList().observe(viewLifecycleOwner,{
            adapter.update(it)
      })

        return binding.root
        }

    }
