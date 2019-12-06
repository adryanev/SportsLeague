package com.adryanev.sportsleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adryanev.sportsleague.data.models.local.Liga
import com.adryanev.sportsleague.databinding.HomeLigaItemBinding
import com.adryanev.sportsleague.ui.home.HomeFragmentDirections
import org.jetbrains.anko.toast

class HomeLigaAdapter : ListAdapter<Liga, HomeLigaAdapter.LigaViewHolder>(LigaDiffCallback()){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeLigaAdapter.LigaViewHolder {
        return LigaViewHolder(HomeLigaItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: HomeLigaAdapter.LigaViewHolder, position: Int) {
        val liga = getItem(position)
        holder.apply {
            bind(createOnClickListener(liga.id,liga.image),liga)
        }
    }

    private fun createOnClickListener(ligaId: Int,ligaImage:String): View.OnClickListener {
        return View.OnClickListener {
            val direction = HomeFragmentDirections.actionNavigationHomeToDetailViewPagerFragment(ligaId,ligaImage)
            it.context.toast("Kamu Ngeklik ID: ${ligaId}")
            it.findNavController().navigate(direction)
        }
    }


    class LigaViewHolder(private val binding : HomeLigaItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Liga){
            binding.apply {
                clicklistener = listener
                liga = item
            }
        }
    }
    class LigaDiffCallback: DiffUtil.ItemCallback<Liga>() {
        override fun areItemsTheSame(oldItem: Liga, newItem: Liga): Boolean {
            return  oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Liga, newItem: Liga): Boolean {
            return oldItem.id == newItem.id
        }

    }
}