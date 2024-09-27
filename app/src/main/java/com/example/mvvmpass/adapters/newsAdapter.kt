package com.example.mvvmpass.adapters

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmpass.Fragments.BriefFragment
import com.example.mvvmpass.Fragments.Home
import com.example.mvvmpass.R
import com.example.mvvmpass.models.NewsDataResponse
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;


class ArticleAdapter(
    val context: Fragment, var brandList: List<NewsDataResponse.Article>) : RecyclerView.Adapter<ArticleAdapter.CategoryHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CategoryHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_article_preview, parent, false)
        return CategoryHolder(v)
    }

    override fun getItemCount(): Int {
        return brandList.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    private var onItemClickListener: ((NewsDataResponse.Article) -> Unit)? = null

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {

        Glide.with(context).load(brandList[position].urlToImage).into(holder.ivArticleImage)
        holder.tvSource.text = brandList[position].source.name
        holder.tvTitle.text = brandList[position].title
        holder.tvDescription.text = brandList[position].description
        holder.tvPublishedAt.text = brandList[position].publishedAt

        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let { it(brandList[position]) }

            }
        }


    }

   fun setOnItemClickListener(listener: (NewsDataResponse.Article) -> Unit) {
        onItemClickListener = listener
    }


    class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivArticleImage: ImageView = itemView.findViewById(R.id.ivArticleImage)
        var tvTitle : TextView = itemView.findViewById(R.id.tvTitle)
        var tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        var tvSource: TextView = itemView.findViewById(R.id.tvSource)
        var tvPublishedAt: TextView = itemView.findViewById(R.id.tvPublishedAt)

    }




}