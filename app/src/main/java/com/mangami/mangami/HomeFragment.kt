package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mangami.mangami.*
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.toolbar_main.*
import android.view.Menu
import android.view.MenuItem
import android.view.MenuInflater
import com.mangami.mangami.R.menu.menu_toolbar_main


class HomeFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var firstViewPager: ViewPager


    /**
     * Initialize newInstance for passing parameters
     */
    companion object {
        fun newInstance(): HomeFragment {
            val fragmentHome = HomeFragment()
            val args = Bundle()
            fragmentHome.arguments = args
            return fragmentHome
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
        (activity as AppCompatActivity).supportActionBar


    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        firstViewPager = rootView.findViewById(R.id.view_pager_home)

        tabLayout = rootView.findViewById(R.id.tabs_home)
        tabLayout.setupWithViewPager(firstViewPager)

        setupViewPager(firstViewPager)

        return rootView
    }


    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = HomeFragmentTabAdapter(childFragmentManager)
        adapter.addFragment(HomeFragmentForYou(), "For You")
        adapter.addFragment(HomeFragmentAll(), "All")
        adapter.addFragment(HomeFragmentNew(), "New")
        viewPager.adapter = adapter
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater?.inflate(R.menu.menu_toolbar_main, menu)
    }

//    //    This adds items to the ActionBar
//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//
//        menuInflater.inflate(R.menu.menu_toolbar_main, menu)
//        return true
//
//    }
//
//

    //    This is the OnClickListener for the Buttons in the ActionBar
    override fun onOptionsItemSelected(item: MenuItem)= when (item.itemId) {
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
}