package com.mangami.mangami

import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

import com.bumptech.glide.Glide
import android.content.Context
import android.content.Intent
import android.support.v7.widget.CardView
import android.widget.ImageButton


/**
 * Created by Ravi Tamada on 18/05/16.
 */
class CardView_MangaAdapter(private val mContext: Context, private val mData: List<Card_Manga>) : RecyclerView.Adapter<CardView_MangaAdapter.MyViewHolder>() {


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var tv_manga_title: TextView
        internal var tv_manga_author: TextView
        internal var img_book_thumbnail: ImageView
        internal var cardView: CardView
        internal var card_manga_overflow: ImageView

        init {

            tv_manga_title = itemView.findViewById(R.id.card_manga_title) as TextView
            tv_manga_author = itemView.findViewById(R.id.card_manga_author) as TextView
            img_book_thumbnail = itemView.findViewById(R.id.card_manga_image) as ImageView
            cardView = itemView.findViewById(R.id.cardview_manga) as CardView
            card_manga_overflow = itemView.findViewById(R.id.card_manga_overflow) as ImageView


        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardView_MangaAdapter.MyViewHolder {

        val view: View
        val mInflater = LayoutInflater.from(mContext)
        view = mInflater.inflate(R.layout.cardview_item_manga, parent, false)
        return CardView_MangaAdapter.MyViewHolder(view)
    }


    override fun onBindViewHolder(holder: CardView_MangaAdapter.MyViewHolder, position: Int) {

        holder.tv_manga_title.text = mData[position].title
        holder.tv_manga_author.text = mData[position].author
        holder.img_book_thumbnail.setImageResource(mData[position].thumbnail)
        holder.cardView.setOnClickListener {
            val intent = Intent(mContext, MangaActivity::class.java)

            // passing data to the manga activity
            intent.putExtra("Title", mData[position].getTitle())
            intent.putExtra("Description", mData[position].getDescription())
            intent.putExtra("Thumbnail", mData[position].getThumbnail())
            // start the activity
            mContext.startActivity(intent)
        }


        holder.card_manga_overflow.setOnClickListener {
            showPopupMenu(holder.card_manga_overflow)
        }

    }
        /**
         * Showing popup menu when tapping on 3 dots
         */
        private fun showPopupMenu(view: View) {
            // inflate menu
            val popup = PopupMenu(mContext, view)
            val inflater = popup.menuInflater
            inflater.inflate(R.menu.menu_manga_card_home, popup.menu)
            popup.setOnMenuItemClickListener(MyMenuItemClickListener())
            popup.show()
        }

        /**
         * Click listener for popup menu items
         */
        internal inner class MyMenuItemClickListener : PopupMenu.OnMenuItemClickListener {

            override fun onMenuItemClick(menuItem: MenuItem): Boolean {
                when (menuItem.itemId) {
                    R.id.card_manga_booklist -> {
                        Toast.makeText(mContext, "Add Bookmark", Toast.LENGTH_SHORT).show()
                        return true
                    }
                    R.id.card_manga_download -> {
                        Toast.makeText(mContext, "Download started", Toast.LENGTH_SHORT).show()
                        return true
                    }
                }
                return false
            }
        }


        override fun getItemCount(): Int {
            return mData.size
        }
    }





