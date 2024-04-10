package com.example.mobiledevelopmentcourselabapp.presentation.view.adapter

import android.text.style.UpdateAppearance
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.bumptech.glide.Glide
import com.example.mobiledevelopmentcourselabapp.R
import com.example.mobiledevelopmentcourselabapp.databinding.ItomPlayerBinding
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.PlayerPosition
import com.example.mobiledevelopmentcourselabapp.presentation.view.second.model.model

class PlayerAdapter(private val onPlayerClicked: (model) -> Unit):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: MutableList<model> = arrayListOf()

    fun updateItems(newItems: List<model>){
        items = newItems.toMutableList()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItomPlayerBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PlayerHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]
        if (holder is PlayerHolder){
            holder.bind(item)
            holder.setOnClickListener{
                onPlayerClicked.invoke(item)
                item.isExpanded = !item.isExpanded
                notifyItemChanged(position)
            }
        }
    }



    class PlayerHolder(private val binding:ItomPlayerBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(player: model){
            binding.name.text = player.name
            binding.age.text = player.age.toString()
            binding.number.text = player.number.toString()
            binding.position.text = player.position.rusName
            binding.team.text = player.team
            binding.additionFields.isVisible = player.isExpanded

            Glide.with(itemView)
                .load(player.photoUrl)
                .into(binding.icon)

        }

        fun setOnClickListener(action: () -> Unit){
            binding.root.setOnClickListener{
                action.invoke()

            }
        }
    }

}