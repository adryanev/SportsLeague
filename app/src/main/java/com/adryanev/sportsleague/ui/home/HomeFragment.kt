package com.adryanev.sportsleague.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.adryanev.sportsleague.R
import com.adryanev.sportsleague.adapters.HomeLigaAdapter
import com.adryanev.sportsleague.databinding.FragmentHomeBinding
import com.adryanev.sportsleague.utils.InjectorUtils
import timber.log.Timber

class HomeFragment : Fragment() {

    private val viewModel : HomeViewModel by viewModels {
        InjectorUtils.provideHomeViewModelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentHomeBinding.inflate(inflater,container,false)

        val adapter = HomeLigaAdapter()
        binding.recyclerView.adapter = adapter

        subscribeUi(adapter)
        Timber.d("Opening HomeFragment")


        return binding.root
    }

    private fun subscribeUi(adapter: HomeLigaAdapter) {

        viewModel.liga.observe(viewLifecycleOwner){
            list -> adapter.submitList(list)
        }

    }
}