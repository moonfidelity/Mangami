package com.mangami.mangami

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MangaActivity : AppCompatActivity() {

    private var tvtitle: TextView? = null
    private var tvdescription: TextView? = null
    private var tvcategory: TextView? = null
    private var img: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)

        tvtitle = findViewById(R.id.txttitle) as TextView
        tvdescription = findViewById(R.id.txtDesc) as TextView
        tvcategory = findViewById(R.id.txtCat) as TextView
        img = findViewById(R.id.bookthumbnail) as ImageView

        // Recieve data
        val intent = intent
        val Title = intent.extras!!.getString("Title")
        val Description = intent.extras!!.getString("Description")
        val image = intent.extras!!.getInt("Thumbnail")

        // Setting values

        tvtitle!!.text = Title
        tvdescription!!.text = Description
        img!!.setImageResource(image)


    }
}