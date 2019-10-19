package com.bn.smkcoding51019

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movie.view.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick

class MovieAdapter(
    val list: List<MovieModel>,
    val context: Context
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    lateinit var itemView: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, list[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(context: Context, movieModel: MovieModel) {
            itemView.tv_title.text = movieModel.title

            Glide.with(context).load(movieModel.image).into(itemView.iv_poster)

            itemView.onClick {
                itemView.context.startActivity(itemView.context.intentFor<DetailMovieActivity>("movie" to movieModel).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                )
            }
        }


    }
}