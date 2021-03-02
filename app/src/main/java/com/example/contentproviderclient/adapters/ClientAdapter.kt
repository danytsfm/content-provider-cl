package com.example.contentproviderclient.adapters

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.contentproviderclient.R
import org.w3c.dom.Text

class ClientAdapter(private val mCursor : Cursor) : RecyclerView.Adapter<ClientViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder =
        ClientViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_client_item, parent,false))


    override fun getItemCount(): Int = mCursor.count

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.clItemTitle.text = mCursor.getString(mCursor.getColumnIndex("title"))
        holder.clItemDesc.text = mCursor.getString(mCursor.getColumnIndex("description"))

    }

}

class ClientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val clItemTitle = itemView.findViewById(R.id.cl_item_title) as TextView
    val clItemDesc = itemView.findViewById(R.id.cl_item_desc) as TextView
}