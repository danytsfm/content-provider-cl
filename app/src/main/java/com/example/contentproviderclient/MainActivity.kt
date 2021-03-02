package com.example.contentproviderclient

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.contentproviderclient.adapters.ClientAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var rvClient : RecyclerView
    private lateinit var fabRefresh : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvClient = findViewById(R.id.rv_client)
        fabRefresh = findViewById(R.id.fab_refresh)
        getContentProvider()

        fabRefresh.setOnClickListener { getContentProvider() }
    }

    fun getContentProvider(){
        try {
            val url = "content://com.example.creatingapi.provider/notes"
            val data = Uri.parse(url)
            val cursor : Cursor? = contentResolver.query(data, null, null, null, "title")
            rvClient.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClientAdapter(cursor as Cursor)
            }
        }
        catch (ex : Exception){
            ex.printStackTrace()
        }

    }
}