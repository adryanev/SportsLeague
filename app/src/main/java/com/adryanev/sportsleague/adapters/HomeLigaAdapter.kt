package com.adryanev.sportsleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adryanev.sportsleague.data.models.local.Liga
import com.adryanev.sportsleague.databinding.HomeLigaItemBinding
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
            bind(createOnClickListener(liga.id),liga)
        }
    }

    private fun createOnClickListener(ligaId: Int): View.OnClickListener {
        return View.OnClickListener {
            it.context.toast("Kamu Ngeklik ID: ${ligaId}")
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