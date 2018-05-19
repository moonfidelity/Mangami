package com.mangami.mangami

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.fragment_home.*

abstract class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        configureTabLayout()


    }

    private fun configureTabLayout() {

        tabs_home.addTab(tabs_home.newTab().setText("For You"))
        tabs_home.addTab(tabs_home.newTab().setText("All"))
        tabs_home.addTab(tabs_home.newTab().setText("New"))




        val pageAdapter = HomeFragmentTabAdapter(supportFragmentManager)



        view_pager_home.adapter = pageAdapter
        tabs_home.setupWithViewPager(view_pager_home)



    }


}