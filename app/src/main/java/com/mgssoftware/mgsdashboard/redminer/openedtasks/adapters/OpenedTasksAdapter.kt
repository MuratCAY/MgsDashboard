package com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mgssoftware.mgsdashboard.databinding.ItemOpenedTasksRecyclerBinding
import com.mgssoftware.mgsdashboard.redminer.data.model.TaskCreated
import com.mgssoftware.mgsdashboard.redminer.openedtasks.adapters.viewholder.OpenedTasksViewHolder

class OpenedTasksAdapter(private val openedTaskList: List<TaskCreated?>?) :
    RecyclerView.Adapter<OpenedTasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenedTasksViewHolder {
        val view = ItemOpenedTasksRecyclerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OpenedTasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: OpenedTasksViewHolder, position: Int) {
        holder.bind(openedTaskList?.get(position))
        if (position == (openedTaskList?.size ?: 0) - 1) {
            holder.itemBinding.line.visibility = View.GONE
        } else {
            View.VISIBLE
        }
    }

    override fun getItemCount(): Int = openedTaskList!!.size
}