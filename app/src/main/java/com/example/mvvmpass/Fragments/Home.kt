package com.example.mvvmpass.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmpass.NewsViewModel
import com.example.mvvmpass.R
import com.example.mvvmpass.adapters.ArticleAdapter
import com.example.mvvmpass.util.ViewModelFactory

class Home: Fragment(R.layout.fragment_home){


    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: LinearLayoutManager
    lateinit var newsAdapter: ArticleAdapter
    lateinit var activityViewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        activityViewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        val factory = ViewModelFactory()
        activityViewModel = activity?.let { ViewModelProvider(it,factory)[NewsViewModel::class.java]}?:throw (Exception("Unknown viewModel class!"))

        val v: View =
            inflater.inflate(R.layout.fragment_home, container, false)
        recyclerView =
            v.findViewById<View>(R.id.rvBreakingNews) as RecyclerView
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(activity)
        recyclerView.setLayoutManager(layoutManager)



        activityViewModel.getUser()?.observe(viewLifecycleOwner, Observer {

                NewsDataResponse ->

            newsAdapter = ArticleAdapter(this, brandList = NewsDataResponse.articles)
            recyclerView.adapter = newsAdapter

            recyclerView.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)

            newsAdapter.setOnItemClickListener {

                activityViewModel.setFacilityDetails(it)

                findNavController().navigate(R.id.action_home2_to_briefFragment)

            }


        })

        return v

    }


}