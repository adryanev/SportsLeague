package com.adryanev.sportsleague.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.adryanev.sportsleague.MobileNavigationDirections
import com.adryanev.sportsleague.data.models.api.event.Event
import com.adryanev.sportsleague.databinding.EventItemBinding

class EventAdapter : ListAdapter<Event, EventAdapter.EventViewHolder>(NextMatchDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            EventItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = getItem(position)
        holder.apply {
            bind(createOnClickListener(event.idEvent), event)
        }
    }

    private fun createOnClickListener(eventId: String?): View.OnClickListener {
        return View.OnClickListener {
            val directions = MobileNavigationDirections.actionGlobalDetailMatch(eventId)
            it.findNavController()
                .navigate(directions)
        }
    }

    class EventViewHolder(private val binding: EventItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(listener: View.OnClickListener, item: Event) {
            binding.apply {
                event = item
                onClickListener = listener

            }
        }
    }

    class NextMatchDiffCallback : DiffUtil.ItemCallback<Event>() {
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.idEvent == newItem.idEvent
        }

    }
}


