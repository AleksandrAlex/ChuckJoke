package com.suslovalex.chuckjoke.view

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.suslovalex.chuckjoke.R
import com.suslovalex.chuckjoke.adapter.JokeAdapter
import com.suslovalex.chuckjoke.databinding.FragmentJokeBinding
import com.suslovalex.chuckjoke.repository.Repository
import com.suslovalex.chuckjoke.viewmodel.JokeViewModel
import com.suslovalex.chuckjoke.viewmodel.JokeViewModelFactory
import kotlinx.android.synthetic.main.fragment_joke.*


class JokeFragment : Fragment() {

    private val repository: Repository by lazy { Repository() }
    private val jokeViewModelFactory: JokeViewModelFactory by lazy { JokeViewModelFactory(repository) }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ShowToast")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentJokeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_joke, container, false)
        val jokeViewModel =
            ViewModelProvider(this, jokeViewModelFactory).get(JokeViewModel::class.java)
        val adapter = JokeAdapter()
        binding.recyclerView.adapter = adapter

        jokeViewModel.response.observe(viewLifecycleOwner, Observer {
                    adapter.data = it.body()?.value!!
        })

        binding.viewModel = jokeViewModel
        binding.lifecycleOwner = this



        return binding.root
    }

}
