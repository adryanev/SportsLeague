package com.adryanev.sportsleague.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.adryanev.sportsleague.MainActivity
import com.adryanev.sportsleague.R
import com.adryanev.sportsleague.adapters.HomeLigaAdapter
import com.adryanev.sportsleague.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : Fragment() {

    private val vm : HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = HomeLigaAdapter()

        val binding = FragmentHomeBinding.inflate(inflater,container,false).apply {
            homeRecyclerview.adapter = adapter
        }

        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding.toolbar)

        }

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