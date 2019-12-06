package com.adryanev.sportsleague.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.adryanev.sportsleague.ui.nextmatch.NextMatchFragment
import com.adryanev.sportsleague.ui.previousmatch.PreviousMatchFragment
import java.lang.IndexOutOfBoundsException

const val NEXT_MATCH_INDEX = 0
const val PREVIOUS_MATCH_INDEX = 1

class DetailLeagueAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val tabFragmentFactory: Map<Int, ()-> Fragment> = mapOf(
        NEXT_MATCH_INDEX to { NextMatchFragment() },
        PREVIOUS_MATCH_INDEX to { PreviousMatchFragment() }
    )
    override fun getItemCount(): Int = tabFragmentFactory.size

    override fun createFragment(position: Int): Fragment {
        return  tabFragmentFactory[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}