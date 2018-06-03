package fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*
import com.mangami.mangami.R
import net.steamcrafted.materialiconlib.MaterialMenuInflater

/**
 * Created by chirag on 31/7/17.
 */
class FragmentBooklist : Fragment() {
    /**
     * Initialize newInstance for passing parameters
     */
    companion object {
        fun newInstance(): FragmentBooklist {
            var fragmentBooklist = FragmentBooklist()
            var args = Bundle()
            fragmentBooklist.arguments = args
            return fragmentBooklist
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        ActionBar Support:
        setHasOptionsMenu(true)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_booklist, container, false)
        return rootView
    }



//    This sets the Items in the Toolbar

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater?.inflate(R.menu.menu_toolbar_booklist, menu)
    }


//    This is the OnClickListener for the Buttons in the Toolbar
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