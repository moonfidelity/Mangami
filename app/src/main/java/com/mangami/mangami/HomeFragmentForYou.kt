package com.mangami.mangami


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView

class HomeFragmentForYou : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home_fragment_for_you, container, false)
        val page = getArguments()?.getInt(PAGE_NUM)

        val tvHello: TextView = view.findViewById(R.id.tv)
        tvHello.text = "Fragment $page"
        return view
    }
    companion object {
        val PAGE_NUM = "PAGE_NUM"
        fun newInstance(page: Int): HomeFragmentForYou {
            val fragment = HomeFragmentForYou()
            val args = Bundle()
            args.putInt(PAGE_NUM, page)
            fragment.setArguments(args)
            return fragment
        }
    }
}