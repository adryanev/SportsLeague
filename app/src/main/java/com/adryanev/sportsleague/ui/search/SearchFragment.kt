package com.adryanev.sportsleague.ui.search

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.adryanev.sportsleague.adapters.EventAdapter
import com.adryanev.sportsleague.data.models.api.search.SearchResponse
import com.adryanev.sportsleague.databinding.FragmentSearchBinding
import com.adryanev.sportsleague.utils.api.Status
import org.koin.androidx.viewmodel.ext.android.viewModel
import timber.log.Timber

class SearchFragment : Fragment() {

    companion object {
        fun newInstance() = SearchFragment()
    }

    private val vm: SearchViewModel by viewModel()

    private lateinit var binding: FragmentSearchBinding
    private val adapter: EventAdapter by lazy { EventAdapter() }


    private fun showEventLoading() {
        Timber.d("Fetching event data from internet")
        binding.shimmerViewContainer.apply {

            startShimmer()
        }
    }

    private fun showError(message: String) {
        Timber.e(message)
    }

    private fun showEventData(data: SearchResponse) {
        Timber.d("Event Data Fetched: ${data.event?.get(0)?.strEvent}")
        binding.shimmerViewContainer.apply {
            stopShimmer()
            visibility = View.GONE
        }
        adapter.submitList(data.event)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false).apply {
            rvSearch.adapter = adapter
            toolbar.setNavigationOnClickListener { view ->
                view.findNavController().navigateUp()
            }

        }
        vm.searchResult.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> showEventData(it.data!!)
                Status.ERROR -> showError(it.message!!)
                Status.LOADING -> showEventLoading()
            }
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupSearchView()

    }

    private fun setupSearchView() {
        val searchManager = context?.getSystemService(Context.SEARCH_SERVICE) as SearchManager
        binding.searchview.apply {
            setSearchableInfo(searchManager.getSearchableInfo(activity?.componentName))
            queryHint = "Search Event"
            imeOptions =
                imeOptions or EditorInfo.IME_ACTION_SEARCH or EditorInfo.IME_FLAG_NO_EXTRACT_UI or EditorInfo.IME_FLAG_NO_FULLSCREEN

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    adapter.submitList(emptyList())
                    clearFocus()
                    vm.query.value = query
                    binding.shimmerViewContainer.visibility = View.VISIBLE
                    Timber.d("query Search = $query")
                    return true

                }

                override fun onQueryTextChange(query: String): Boolean {
                    if (TextUtils.isEmpty(query)) {
                        adapter.submitList(emptyList())
                    }
                    return true
                }
            })
        }
    }


}
