package com.reza.githubapp.ui.search.paging

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reza.githubapp.databinding.ItemSearchBinding
import com.reza.githubapp.model.SearchItemUiModel

class SearchPagingAdapter : PagingDataAdapter<SearchItemUiModel, SearchUserViewHolder>(ItemsDiffCallBack()) {

    var onClickItem: (SearchItemUiModel) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchUserViewHolder {
        return SearchUserViewHolder(
            ItemSearchBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ), onClickItem
        )
    }

    override fun onBindViewHolder(holder: SearchUserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear(lifecycle: Lifecycle) {
        submitData(lifecycle, PagingData.empty())
        notifyDataSetChanged()
    }
}

class ItemsDiffCallBack : DiffUtil.ItemCallback<SearchItemUiModel>() {
    override fun areItemsTheSame(oldItem: SearchItemUiModel, newItem: SearchItemUiModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SearchItemUiModel, newItem: SearchItemUiModel): Boolean {
        return oldItem == newItem
    }
}


class SearchUserViewHolder(private val binding: ItemSearchBinding, private val onClickItem: (SearchItemUiModel) -> Unit) : RecyclerView.ViewHolder(binding.root){
    fun bind(model: SearchItemUiModel?){
        if (model == null)
            return

        Glide.with(binding.root)
            .load(model.avatar_url)
            .into(binding.imageUser)

        binding.txtUsername.text = model.login

        binding.rootLayout.setOnClickListener {
            onClickItem(model)
        }
    }
}