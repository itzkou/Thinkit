package com.kou.thinkit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kou.thinkit.Common.SimpleCallback
import com.kou.thinkit.Model.Room
import com.kou.thinkit.R
import kotlinx.android.synthetic.main.row_home.view.*

class RvHomeAdapter() : RecyclerView.Adapter<RvHomeAdapter.ViewHolder>() {


    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    private var rooms = listOf<Room>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_home, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val room = rooms[position]
        with(holder.view) {
            imCard.setImageResource(room.image)
            tvTilte.text = room.name
            val deviceCount = holder.view.context.resources.getQuantityString(
                R.plurals.device_count, room.nbDevice, room.nbDevice)
           tvNbDevice.text = deviceCount
        }

    }

    override fun getItemCount() = rooms.size

    fun updateRooms(newRooms: List<Room>) {
        val diffResult = DiffUtil.calculateDiff(SimpleCallback(this.rooms, newRooms) { it })
        this.rooms = newRooms
        diffResult.dispatchUpdatesTo(this)
    }


}