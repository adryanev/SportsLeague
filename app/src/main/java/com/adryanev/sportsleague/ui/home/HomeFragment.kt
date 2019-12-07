package com.adryanev.sportsleague.ui.home

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.adryanev.sportsleague.MobileNavigationDirections
import com.adryanev.sportsleague.R
import com.adryanev.sportsleague.adapters.HomeLigaAdapter
import com.adryanev.sportsleague.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class HomeFragment : Fragment() {

    private val vm: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val adapter = HomeLigaAdapter()

        val binding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            homeRecyclerview.adapter = adapter
        }

        (activity as AppCompatActivity).apply {
            setSupportActionBar(binding.toolbar)

        }
        setHasOptionsMenu(true)
        subscribeUi(adapter)
        Timber.d("Opening HomeFragment")


        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.app_bar_search -> {
                findNavController().navigate(MobileNavigationDirections.actionGlobalSearchFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun subscribeUi(adapter: HomeLigaAdapter) {

        vm.liga.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }

    }
}