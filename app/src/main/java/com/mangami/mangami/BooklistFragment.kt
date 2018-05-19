package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mangami.mangami.R

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
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_booklist, container, false)
        return rootView
    }


}