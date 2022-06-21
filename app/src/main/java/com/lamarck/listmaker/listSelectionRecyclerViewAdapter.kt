package com.lamarck.listmaker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListSelectionRecyclerViewAdapter(private val lists:ArrayList<TaskList>):
    RecyclerView.Adapter<ListSelectionRecyclerViewAdapter.ListSelectionViewHolder>() {

    //val listTitle = arrayOf("Shopping List","Chores","Android Tutorials")


    inner class ListSelectionViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val listPosition = itemView.findViewById(R.id.itemNumber) as TextView
        val listTitle = itemView.findViewById(R.id.itemString) as TextView

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ListSelectionViewHolder {



        val view =LayoutInflater.from(parent.context)
            .inflate(R.layout.list_selection_view_holder,parent,false)

        return ListSelectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListSelectionViewHolder, position: Int) {
        holder.listPosition.text = (position + 1).toString()
        holder.listTitle.text = lists.get(position).name
    }

    override fun getItemCount(): Int {

        return lists.size
    }

    fun addList(list:TaskList){
        lists.add(list)

        notifyItemInserted(lists.size-1)
    }
}