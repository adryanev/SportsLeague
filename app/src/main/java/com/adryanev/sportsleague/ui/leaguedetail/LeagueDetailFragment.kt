package com.adryanev.sportsleague.ui.leaguedetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs

import com.adryanev.sportsleague.R
import com.adryanev.sportsleague.data.models.api.LeagueDetailResponse
import com.adryanev.sportsleague.databinding.LeagueDetailFragmentBinding
import com.adryanev.sportsleague.utils.api.Resource
import com.adryanev.sportsleague.utils.api.Status
import org.koin.android.ext.android.getKoin
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import timber.log.Timber

class LeagueDetailFragment : Fragment() {

    lateinit var binding: LeagueDetailFragmentBinding
    private val args : LeagueDetailFragmentArgs by navArgs()
    private val vm : LeagueDetailViewModel by viewModel{ parametersOf(args.leagueId)}

    private val observer = Observer<Resource<LeagueDetailResponse>> {
        Timber.d("Observing View Model")
        Timber.d(it.status.toString())
        when(it.status){
            Status.SUCCESS -> showData(it.data!!)
            Status.ERROR -> showError(it.message!!)
            Status.LOADING -> showLoading()
        }
    }

    private fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showError(message: String) {
        Timber.e(message)
    }

    private fun showData(data: LeagueDetailResponse) {
        binding.liga = data.leagues?.get(0)
        Timber.d(binding.liga?.strLeague)
    }

    companion object {
        fun newInstance() = LeagueDetailFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getKoin().setProperty("leagueId",args.leagueId)
        binding = LeagueDetailFragmentBinding.inflate(inflater,container,false)
        Timber.d("Membuka LeagueDetailFragment")
        vm.detail.observe(viewLifecycleOwner,observer)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Timber.d("Activity Created")

    }

}
