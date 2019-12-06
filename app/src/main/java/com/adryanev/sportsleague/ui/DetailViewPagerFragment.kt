package com.adryanev.sportsleague.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.adryanev.sportsleague.R
import com.adryanev.sportsleague.adapters.DetailLeagueAdapter
import com.adryanev.sportsleague.adapters.NEXT_MATCH_INDEX
import com.adryanev.sportsleague.adapters.PREVIOUS_MATCH_INDEX
import com.adryanev.sportsleague.databinding.FragmentDetailViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_detail_view_pager.*

class DetailViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentDetailViewPagerBinding.inflate(inflater,container,false)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = DetailLeagueAdapter(this)

        TabLayoutMediator(tabLayout,viewPager) { tab, position  ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        binding.toolbar.setNavigationOnClickListener { view -> view.findNavController().navigateUp() }

        return binding.root
    }

    private fun getTabIcon(position:Int) : Int {
        return when(position){
            NEXT_MATCH_INDEX -> R.drawable.ic_navigate_next_black_24dp
            PREVIOUS_MATCH_INDEX -> R.drawable.ic_navigate_before_black_24dp
            else -> throw IndexOutOfBoundsException()
        }
    }

    private fun getTabTitle(position: Int) : String? {
        return when(position){
            NEXT_MATCH_INDEX -> "Next Match"
            PREVIOUS_MATCH_INDEX -> "Previous Match"
            else -> null
        }
    }
}