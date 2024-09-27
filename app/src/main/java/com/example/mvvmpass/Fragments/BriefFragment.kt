package com.example.mvvmpass.Fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmpass.NewsViewModel
import com.example.mvvmpass.R
import com.example.mvvmpass.databinding.FragmentBriefBinding
import com.example.mvvmpass.util.ViewModelFactory

class BriefFragment: Fragment(R.layout.fragment_brief) {

    private var _binding: FragmentBriefBinding? = null
    private val binding get() = _binding!!
    lateinit var activityViewModel: NewsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {


        _binding = FragmentBriefBinding.inflate(inflater, container, false)

        val factory = ViewModelFactory()
        activityViewModel = ViewModelProvider(this,factory)[NewsViewModel::class.java]
        activityViewModel =  activity?.let { ViewModelProvider(it,factory)[NewsViewModel::class.java]}?:throw (Exception("Unknown viewModel class!"))

       activityViewModel.getData.observe(viewLifecycleOwner){

           binding.webView.apply {
               webViewClient = WebViewClient()
               loadUrl(it.url)
           }

       }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}