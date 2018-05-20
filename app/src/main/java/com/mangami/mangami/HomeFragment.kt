package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mangami.mangami.*
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager


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

}