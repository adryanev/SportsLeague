package com.adryanev.sportsleague.ui.detailviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.adryanev.sportsleague.R
import com.adryanev.sportsleague.adapters.DetailLeagueAdapter
import com.adryanev.sportsleague.adapters.NEXT_MATCH_INDEX
import com.adryanev.sportsleague.adapters.PREVIOUS_MATCH_INDEX
import com.adryanev.sportsleague.data.models.api.league.LeagueDetailResponse
import com.adryanev.sportsleague.databinding.FragmentDetailViewPagerBinding
import com.adryanev.sportsleague.utils.api.Resource
import com.adryanev.sportsleague.utils.api.Status
import com.google.android.material.tabs.TabLayoutMediator
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.support.v4.toast
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class DetailViewPagerFragment : Fragment() {


    val argument : DetailViewPagerFragmentArgs by navArgs()
    val detailViewModel : DetailViewPagerViewModel by viewModel()
    lateinit var binding : FragmentDetailViewPagerBinding

    private val leagueObserver = Observer<Resource<LeagueDetailResponse>> {
        when(it.status){
            Status.SUCCESS -> showLeagueData(it.data!!)
            Status.ERROR -> showError(it.message!!)
            Status.LOADING -> showLeagueLoading()
        }
    }

    private fun showError(message: String) {
        binding.root.snackbar(message).show()
        Timber.d(message)
    }

    private fun showLeagueLoading() {
        binding.shimmerViewContainer.startShimmer()

    }

    private fun showLeagueData(data: LeagueDetailResponse) {
        binding.apply {
            shimmerViewContainer.stopShimmer()
            shimmerViewContainer.visibility = View.GONE
            league = data.leagues?.get(0)
            imageRaw = argument.leagueImage
            detailContainer.detailContainer.visibility = View.VISIBLE

        }
        Timber.d(binding.league?.strLeague)



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailViewPagerBinding.inflate(inflater,container,false)
        getKoin().apply {
            setProperty("leagueId",argument.leagueId)
            setProperty("leagueImage",argument.leagueImage!!)

        }
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager

        viewPager.adapter = DetailLeagueAdapter(this)

        TabLayoutMediator(tabLayout,viewPager) { tab, position  ->
            tab.setIcon(getTabIcon(position))
            tab.text = getTabTitle(position)
        }.attach()

        binding.toolbar.setNavigationOnClickListener { view -> view.findNavController().navigateUp() }
        detailViewModel.leagueDetail.observe(viewLifecycleOwner,leagueObserver)
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