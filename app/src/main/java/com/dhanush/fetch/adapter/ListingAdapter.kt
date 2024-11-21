package com.dhanush.fetch.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dhanush.fetch.R
import com.dhanush.fetch.model.Item

//Adapter for RecyclerView to display list of items.
class ListingAdapter(private val dataset:List<Item>): RecyclerView.Adapter<ListingAdapter.ItemViewHolder>()
{
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val id:TextView=view.findViewById(R.id.id)            //id textview
        val listId:TextView=view.findViewById(R.id.listId)    //listId textview
        val name:TextView=view.findViewById(R.id.name)        //name textview
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        //assign values to TextViews
        holder.id.text= item.id.toString()
        holder.listId.text= item.listId.toString()
        holder.name.text= item.name

    }
    override fun getItemCount() = dataset.size
}
