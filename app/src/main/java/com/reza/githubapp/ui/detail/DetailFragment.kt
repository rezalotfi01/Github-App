package com.reza.githubapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.reza.githubapp.R
import com.reza.githubapp.databinding.FragmentDetailBinding
import com.reza.githubapp.model.UserDetailsUiModel
import com.reza.githubapp.utils.extensions.getAllVisibleChildrenByTag
import com.reza.githubapp.utils.extensions.getAllVisibleDirectChildren
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val viewModel: DetailViewModel by viewModel()
    private val binding: FragmentDetailBinding by viewBinding()

    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObservables()

        showLoading()
        loadData()
    }

    /**
     * Initializing Views and ViewCallbacks
     */
    private fun initViews(){
        binding.btnRetry.setOnClickListener {
            showLoading()
            loadData()
        }
    }

    /**
     * Initializing listening to the Observable fields
     */
    private fun initObservables(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.userDetailFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .filterNotNull()
                .onEach {
                    showData()
                    setData(it)
                }
                .launchIn(this)

            viewModel.errorFlow
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .filterNotNull()
                .onEach {
                    showError(it)
                }
                .collect()

        }
    }

    /**
     * Start to loading Data
     */
    private fun loadData(){
        viewModel.getUserDetail(args.username)
//        binding.viewContributions.loadUserName(args.username)
    }

    /**
     * Set Data on the Views
     */
    private fun setData(data: UserDetailsUiModel){
        with(binding){

            Glide.with(binding.root)
                .load(data.avatar_url)
                .into(binding.imageUser)

            txtUserName.text = "@".plus(data.login)
            txtFollowersCount.text = data.followers.toString()
            txtFollowingsCount.text = data.following.toString()
            txtRepositoriesCount.text = data.public_repos.toString()

            if (data.name.isNullOrEmpty().not())
                txtName.text = data.name
            else
                txtName.text = getString(R.string.no_name)

            if (data.bio.isNullOrEmpty().not())
                txtBio.text = data.bio
            else
                txtBio.isVisible = false

            if (data.email.isNullOrEmpty().not())
                txtEmail.text = data.email
            else
                layoutEmail.isVisible = false

            if (data.location.isNullOrEmpty().not())
                txtLocation.text = data.location
            else
                layoutLocation.isVisible = false

            if (data.company.isNullOrEmpty().not())
                txtCompany.text = data.company
            else
                layoutCompany.isVisible = false

            if (data.blog.isNullOrEmpty().not())
                txtWebsite.text = data.blog
            else
                layoutWebsite.isVisible = false

            if (layoutDetailInfo.getAllVisibleDirectChildren().isEmpty())
                cardDetailInfo.isVisible = false


            /**
             * This Block of code is for hiding the first Divider line View
             */
            layoutDetailInfo.getAllVisibleChildrenByTag(getString(R.string.lines))
                .firstOrNull()?.isVisible = false

        }
    }

    private fun showData(){
        with(binding){
            root.post {
                layoutError.isVisible = false
                viewLoading.isVisible = false
                viewLoading.cancelAnimation()
                layoutData.isVisible = true
            }
        }
    }

    private fun showLoading(){
        with(binding){
            root.post {
                layoutError.isVisible = false
                layoutData.isVisible = false
                viewLoading.isVisible = true
                viewLoading.playAnimation()
            }
        }
    }

    private fun showError(throwable: Throwable){
        with(binding) {
            root.post {
                layoutError.isVisible = true
                layoutData.isVisible = false
                viewLoading.isVisible = false
                viewLoading.cancelAnimation()

                txtErrorDescription.text = throwable.message
            }
        }
    }
}