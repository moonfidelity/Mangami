package com.mangami.mangami


import android.content.ClipData
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View

import android.graphics.Rect
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.widget.ImageView

import com.bumptech.glide.Glide

import kotlin.collections.MutableList
import kotlin.collections.ArrayList
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.mangami.mangami.HomeFragmentForYou.GridSpacingItemDecoration
import android.support.annotation.DimenRes
import android.support.annotation.NonNull
import com.scwang.smartrefresh.header.StoreHouseHeader










class HomeFragmentForYou : Fragment() {

    internal lateinit var lstBook: MutableList<Book>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_home_fragment_for_you, container, false)




        val recyclerView = rootView.findViewById(R.id.recyclerview_id) as RecyclerView

        recyclerView.layoutManager = GridLayoutManager(activity, 3)


        recyclerView.addItemDecoration(GridSpacingItemDecoration(3, dpToPx(5), true))
        recyclerView.itemAnimator = DefaultItemAnimator()



        val myAdapter = RecyclerViewAdapter(getActivity()!!.getApplicationContext(), lstBook)
        recyclerView.adapter = myAdapter



        return rootView
    }



//    Stuff for Cards:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lstBook = java.util.ArrayList()
        lstBook.add(Book("Hero Academia", "Categorie Book", "Description book", R.drawable.thevigitarian))
        lstBook.add(Book("Naruto", "Categorie Book", "Description book", R.drawable.thewildrobot))
        lstBook.add(Book("Aventura", "Categorie Book", "Description book", R.drawable.mariasemples))
        lstBook.add(Book("Mirai Nikki", "Categorie Book", "Description book", R.drawable.themartian))
        lstBook.add(Book("Hero Academia", "Categorie Book", "Description book", R.drawable.thevigitarian))
        lstBook.add(Book("Naruto", "Categorie Book", "Description book", R.drawable.thewildrobot))
        lstBook.add(Book("Aventura", "Categorie Book", "Description book", R.drawable.mariasemples))
        lstBook.add(Book("Mirai Nikki", "Categorie Book", "Description book", R.drawable.themartian))
        lstBook.add(Book("Hero Academia", "Categorie Book", "Description book", R.drawable.thevigitarian))
        lstBook.add(Book("Naruto", "Categorie Book", "Description book", R.drawable.thewildrobot))
        lstBook.add(Book("Aventura", "Categorie Book", "Description book", R.drawable.mariasemples))
        lstBook.add(Book("Mirai Nikki", "Categorie Book", "Description book", R.drawable.themartian))
    }







    inner class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
            val position = parent.getChildAdapterPosition(view) // item position
            val column = position % spanCount // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing
                }
                outRect.bottom = spacing // item bottom
            } else {
                outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }



}