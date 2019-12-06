package com.adryanev.sportsleague.ui.nextmatch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import org.koin.androidx.viewmodel.ext.android.viewModel


import com.adryanev.sportsleague.R
import com.adryanev.sportsleague.adapters.EventAdapter
import com.adryanev.sportsleague.data.models.api.event.EventResponse
import com.adryanev.sportsleague.databinding.NextMatchFragmentBinding
import com.adryanev.sportsleague.utils.api.Resource
import com.adryanev.sportsleague.utils.api.Status
import org.koin.android.ext.android.getKoin
import timber.log.Timber

class NextMatchFragment : Fragment() {

    companion object {
        fun newInstance() = NextMatchFragment()
    }

    val viewModel: NextMatchViewModel by viewModel()

    lateinit var binding: NextMatchFragmentBinding
    val observer = Observer<Resource<EventResponse>>{
        when(it.status){
            Status.SUCCESS -> showEventData(it.data!!)
            Status.ERROR -> showError(it.message!!)
            Status.LOADING -> showEventLoading()
        }
    }
    val adapter by lazy { EventAdapter() }

    private fun showEventLoading() {
        binding.shimmerViewContainer.startShimmer()
    }

    private fun showError(message: String) {
        Timber.e(message)
    }

    private fun showEventData(data: EventResponse) {
        binding.shimmerViewContainer.apply {
            stopShimmer()
            visibility = View.GONE
        }
        adapter.submitList(data.events)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NextMatchFragmentBinding.inflate(inflater,container,false)
        binding.nextMatchRv.adapter = adapter
        viewModel.nextMatch.observe(viewLifecycleOwner,observer)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}
