package com.example.grocery_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// The adapter acts as a bridge bet. the data source and
// the 'RecyclerView' UI component.
class MyAdapter (val itemsList:ArrayList<ItemModel>)
    : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

        // ViewHolder: holding references to the views for a single
        // item in the 'RecyclerView'
        // itemView: represents the view for a single item in RV
            inner class MyViewHolder(itemView: View)
            :RecyclerView.ViewHolder(itemView){

                var itemImg: ImageView
                var itemTitle: TextView
                var itemDesc: TextView

                init{
                    itemImg = itemView.findViewById(R.id.imageView)
                    itemTitle = itemView.findViewById(R.id.title_txt)
                    itemDesc = itemView.findViewById(R.id.description_text)

                    itemView.setOnClickListener(){
                        Toast.makeText(
                            itemView.context,
                            "You choose: ${itemsList[adapterPosition].name}",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // called when RV needs a new Viewholder Instance
        // inflating the layout for a single item and returning a new WH
        // viewGroup: is the parent view that the new view will be attached to
        //            after it;s bound to its data
        // viewType: in many cases you might have only on type of view
        //           used to distinguish bet, different view types

        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)

        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        // returns the total number of items in the data set
        return itemsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // bind data to a ViewHolder at a specific postion

        holder.itemTitle.setText(itemsList[position].name)
        holder.itemDesc.setText(itemsList[position].desc)
        holder.itemImg.setImageResource(itemsList[position].img)
    }


}