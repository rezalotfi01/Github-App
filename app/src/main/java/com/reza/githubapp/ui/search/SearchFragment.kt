package com.reza.githubapp.ui.search

import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.reza.githubapp.R
import com.reza.githubapp.databinding.FragmentSearchBinding
import com.reza.githubapp.ui.search.paging.SearchPagingAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.imaginativeworld.oopsnointernet.callbacks.ConnectionCallback
import org.imaginativeworld.oopsnointernet.dialogs.signal.NoInternetDialogSignal
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val viewModel: SearchViewModel by viewModel()
    private val binding: FragmentSearchBinding by viewBinding()

    private val usersAdapter = SearchPagingAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecycler()
        initSearch()
        initObservables()

        checkInternet()
    }

    /**
     * Checking the internet and if it's not connected, it will show dialog to the user
     */
    private fun checkInternet() {
        NoInternetDialogSignal.Builder(
            requireActivity(),
            lifecycle
        ).apply {
            dialogProperties.apply {
                connectionCallback = object : ConnectionCallback {
                    override fun hasActiveConnection(hasActiveConnection: Boolean) {

                    }
                }

                cancelable = false
                noInternetConnectionTitle = getString(R.string.not_internet)
                noInternetConnectionMessage = getString(R.string.check_your_internet)

                showInternetOnButtons = true
                pleaseTurnOnText = getString(R.string.please_turn_on)
                wifiOnButtonText = getString(R.string.wifi)
                mobileDataOnButtonText = getString(R.string.mobile_data)

                onAirplaneModeTitle = getString(R.string.not_internet)
                onAirplaneModeMessage = getString(R.string.on_airplane_message)
                pleaseTurnOffText = getString(R.string.please_turn_off)
                airplaneModeOffButtonText = getString(R.string.airplane_mode_off)
                showAirplaneModeOffButtons = true
            }
        }.build()
    }

    /**
     * Initialize the Data Flows listeners and Callbacks
     */
    private fun initObservables() {
        viewLifecycleOwner.lifecycleScope.launch {

            viewModel.usersDataFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .filterNotNull()
                .onEach {
                    usersAdapter.submitData(it)
                }
                .collect()


            viewModel.errorFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .filterNotNull()
                .onEach {
                    showRecyclerOrEmpty()
                    val errorText = getString(R.string.error_happened) + "\n" + it.message.orEmpty()
                    Toast.makeText(requireContext(), errorText, Toast.LENGTH_LONG).show()
                }
                .collect()
        }
    }


    /**
     * Initialize RecyclerView and Adapter of RecyclerView.
     */
    private fun initRecycler() {
        binding.recyclerUsers.adapter = usersAdapter
        usersAdapter.addLoadStateListener {
            if (it.refresh is LoadState.NotLoading)
                showRecyclerOrEmpty()
            else if (it.refresh is LoadState.Error){
                showError()
            }
        }
        usersAdapter.onClickItem = {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToDetailFragment(it.login)
            )
        }
    }

    /**
     * Initialize SearchView and callbacks
     */
    private fun initSearch() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    if (it.isNotEmpty()) {
                        usersAdapter.clear(lifecycle)
                        viewModel.searchUser(query)
                        binding.searchView.clearFocus()
                        showLoading()
                    } else {
                        usersAdapter.clear(lifecycle)
                        binding.searchView.clearFocus()
                        showRecyclerOrEmpty()
                    }
                }
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean = false
        })

        binding.searchView.setOnCloseListener {
            showRecyclerOrEmpty()
            return@setOnCloseListener false
        }
    }


    /**
     * A method for displaying the LoadingView then it's fetching data
     */
    private fun showLoading() {
        with(binding) {
            root.post {
                viewLoading.isVisible = true
                recyclerUsers.isVisible = false
                layoutEmpty.isVisible = false
            }
        }
    }

    /**
     * If recycler is Empty, it should display the textview for informing user.
     * And if it's not empty, It should display the Users List in RecyclerView
     */
    private fun showRecyclerOrEmpty() {
        with(binding) {
            root.post {
                val isEmpty = usersAdapter.itemCount == 0
                recyclerUsers.isVisible = isEmpty.not()
                viewLoading.isVisible = false
                layoutEmpty.isVisible = isEmpty
            }
        }
    }

    private fun showError(errorMessage: String = ""){
        showRecyclerOrEmpty()
        val errorText = getString(R.string.error_happened) + "\n" + errorMessage
        Toast.makeText(requireContext(), errorText, Toast.LENGTH_LONG).show()
    }

}