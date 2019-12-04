package com.adryanev.sportsleague.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import com.adryanev.sportsleague.adapters.HomeLigaAdapter
import com.adryanev.sportsleague.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : Fragment() {

    val vm : HomeViewModel by viewModel()

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

        vm.liga.observe(viewLifecycleOwner){
            list -> adapter.submitList(list)
        }

    }
}