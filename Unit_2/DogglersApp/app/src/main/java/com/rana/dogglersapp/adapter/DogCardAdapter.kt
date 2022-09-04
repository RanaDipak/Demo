package com.rana.dogglersapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rana.dogglersapp.const.Layout
import com.rana.dogglersapp.R

/**
 * Adapter to inflate the appropriate list item layout and populate the view with information
 * from the appropriate data source
 */
class DogCardAdapter(
    private val context: Context?,
    private val layout: Int
): RecyclerView.Adapter<DogCardAdapter.DogCardViewHolder>() {

    // TODO: Initialize the data using the List found in data/DataSource
    private val dataset = DataSource.dogs

    /**
     * Initialize view elements
     */
    class DogCardViewHolder(view: View?): RecyclerView.ViewHolder(view!!) {
        // TODO: Declare and initialize all of the list item UI components
        val imageView: ImageView? = view!!.findViewById(R.id.dog_image)
        val nameView: TextView? = view!!.findViewById(R.id.dog_name)
        val ageView: TextView? = view!!.findViewById(R.id.dog_age)
        val hobbyView: TextView? = view!!.findViewById(R.id.dog_hobby)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogCardViewHolder {
        // TODO: Use a conditional to determine the layout type and set it accordingly.
        //  if the layout variable is Layout.GRID the grid list item should be used. Otherwise the
        //  the vertical/horizontal list item should be used.

        // TODO Inflate the layout
        if(layout == Layout.GRID){
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.grid_list_item, parent, false)
            return DogCardViewHolder(adapterLayout)
        }
        else{
            val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.vertical_horizontal_list_item, parent, false)
            return DogCardViewHolder(adapterLayout)
        }

        // TODO: Null should not be passed into the view holder. This should be updated to reflect
        //  the inflated layout.
    }

    override fun getItemCount(): Int{
        return dataset.size
    } // TODO: return the size of the data set instead of 0

    override fun onBindViewHolder(holder: DogCardViewHolder, position: Int) {
        // TODO: Get the data at the current position
        val dog = dataset[position]
        // TODO: Set the image resource for the current dog
        holder.imageView?.setImageResource(dog.imageResourceId)
        // TODO: Set the text for the current dog's name
        holder.nameView?.text = dog.name
        // TODO: Set the text for the current dog's age
        val resources = context?.resources
        holder.ageView?.text = resources?.getString(R.string.dog_age, dog.age)
        // TODO: Set the text for the current dog's hobbies by passing the hobbies to the
        //  R.string.dog_hobbies string constant.
        //  Passing an argument to the string resource looks like:
        //  resources?.getString(R.string.dog_hobbies, dog.hobbies)
        holder.hobbyView?.text = resources?.getString(R.string.dog_hobbies, dog.hobbies)
    }
}
