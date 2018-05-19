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
class FragmentRecent : Fragment() {
    /**
     * Initialize newInstance for passing parameters
     */
    companion object {
        fun newInstance(): FragmentRecent {
            var fragmentRecent = FragmentRecent()
            var args = Bundle()
            fragmentRecent.arguments = args
            return fragmentRecent
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_recent, container, false)
        return rootView
    }


}