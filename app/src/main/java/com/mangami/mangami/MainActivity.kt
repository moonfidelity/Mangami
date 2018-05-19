package com.mangami.mangami

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout

import fragment.HomeFragment
import fragment.FragmentBooklist
import fragment.FragmentRecent
import fragment.FragmentDownloads
import kotlinx.android.synthetic.main.toolbar_main.*


class MainActivity : AppCompatActivity() {

    private var content: FrameLayout? = null


//    BOTTOM NAVIGATION VIEW

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->


//        This Part disables the Shifting in the BottomNavigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView)


//        What happens when the BottomNavigation Items are clicked is written here
        when (item.itemId) {
            R.id.navigation_home -> {

                val fragment = HomeFragment.Companion.newInstance()
                addFragment(fragment)


                toolbar_main.setTitle("Home")



                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_booklist -> {

                val fragment = FragmentBooklist.Companion.newInstance()
                addFragment(fragment)


                toolbar_main.setTitle("Booklist")


                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_recent -> {

                val fragment = FragmentRecent.Companion.newInstance()
                addFragment(fragment)


                toolbar_main.setTitle("Recent")


                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_downloads -> {

                val fragment = FragmentDownloads.Companion.newInstance()
                addFragment(fragment)


                toolbar_main.setTitle("Downloads")


                return@OnNavigationItemSelectedListener true
            }
        }
        false

    }



//    The method to add, animate and change between Fragments:

    private fun addFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_snackbar_in, R.anim.design_snackbar_out)
                .replace(R.id.content, fragment, fragment.javaClass.getSimpleName())
                .addToBackStack(fragment.javaClass.getSimpleName())
                .commit()
    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        val bottomNavigationView: BottomNavigationView
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation)


//        This selects the menu which should open first in the BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        bottomNavigationView.selectedItemId = R.id.navigation_home


//        This is important so the Frame named "content" will be set

        content = findViewById(R.id.content) as FrameLayout
        val navigation = findViewById(R.id.navigation) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



//        ActionBarSupport
        setSupportActionBar(findViewById(R.id.toolbar_main))



    }

//
//    ACTION BAR
//

//    This adds items to the ActionBar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar_main, menu)
        return true
    }


//    This is the OnClickListener for the Buttons in the ActionBar
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
    R.id.toolbar_edit -> {


        true
    }

    R.id.toolbar_search -> {


        true
    }

    else -> {
        // If we got here, the user's action was not recognized.
        // Invoke the superclass to handle it.
        super.onOptionsItemSelected(item)
    }
}
//
//    ACTION BAR CLOSED
//






}
