package com.adryanev.sportsleague.ui.detailmatch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.adryanev.sportsleague.data.models.api.event.EventResponse
import com.adryanev.sportsleague.databinding.FragmentDetailMatchBinding
import com.adryanev.sportsleague.utils.api.Resource
import com.adryanev.sportsleague.utils.api.Status
import kotlinx.android.synthetic.main.event_item.*
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class DetailMatchFragment : Fragment() {

    companion object {
        fun newInstance() = DetailMatchFragment()
    }

    private val vm: DetailMatchViewModel by viewModel()
    private val observer = Observer<Resource<EventResponse>> {
        when (it.status) {
            Status.SUCCESS -> showEventData(it.data!!)
            Status.ERROR -> showError(it.message!!)
            Status.LOADING -> showEventLoading()
        }
    }
    private val args: DetailMatchFragmentArgs by navArgs()
    private lateinit var binding: FragmentDetailMatchBinding

    private fun showEventLoading() {
        binding.apply {
            shimmerDetailMatch.startShimmer()
            shimmerViewContainer.startShimmer()
        }

    }

    private fun showError(message: String) {
        Timber.e(message)
    }

    private fun showEventData(data: EventResponse) {
        binding.apply {
            shimmerViewContainer.apply {
                stopShimmer()
                visibility = View.GONE
            }
            shimmerDetailMatch.apply {
                stopShimmer()
                visibility = View.GONE
            }
            event_container.visibility = View.VISIBLE
            detailScrollView.visibility = View.VISIBLE
            event = data.events?.get(0)
        }

        vm.getTeamHome(binding.event?.idHomeTeam?.toInt()!!)
        vm.getTeamAway(binding.event?.idAwayTeam?.toInt()!!)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailMatchBinding.inflate(inflater, container, false)
        binding.toolbar.setNavigationOnClickListener { view ->
            view.findNavController().navigateUp()
        }
        getKoin().setProperty("eventId", args.eventId!!.toInt())
        vm.evetDetail.observe(viewLifecycleOwner, observer)
        vm.teamHome.observe(viewLifecycleOwner) {
            binding.home = it
        }
        vm.teamAway.observe(viewLifecycleOwner) {
            binding.away = it
        }
        return binding.root
    }


}
