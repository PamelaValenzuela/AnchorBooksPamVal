package com.example.anchorbooks.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.anchorbooks.databinding.ListViewholderBinding
import com.example.anchorbooks.model.dataClass.Books

class ListAdapter: RecyclerView.Adapter<ListAdapter.BooksVH>() {

    private var booksListvh = listOf<Books>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksVH {
        val binding =ListViewholderBinding.inflate(LayoutInflater.from(parent.context))
        return BooksVH(binding)
    }

    override fun onBindViewHolder(holder: BooksVH, position: Int) {
        val bookp= booksListvh[position]
        holder.bind(bookp)
    }

    override fun getItemCount(): Int {
        return booksListvh.size
    }

    fun update(pBooksList: List<Books>){
        booksListvh= pBooksList
        notifyDataSetChanged()
    }
    class BooksVH(val binding: ListViewholderBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(book: Books){
            binding.bookName.text= book.title
            binding.authorBook.text= book.author
            Picasso.get().load().placeholder(R.drawable.ic_launcher_foreground).centerCrop().into()
        }

    }
}