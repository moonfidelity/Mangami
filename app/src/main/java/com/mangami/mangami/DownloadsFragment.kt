package fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mangami.mangami.R


class FragmentDownloads : Fragment() {
    /**
     * Initialize newInstance for passing parameters
     */
    companion object {
        fun newInstance(): FragmentDownloads {
            var fragmentDownloads = FragmentDownloads()
            var args = Bundle()
            fragmentDownloads.arguments = args
            return fragmentDownloads
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_downloads, container, false)
        return rootView
    }


}