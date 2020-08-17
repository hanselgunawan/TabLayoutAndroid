package com.hanseltritama.tablayoutdemo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    private var tabTitle: ArrayList<String> = arrayListOf()

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstFragment()
            } 1 -> {
                SecondFragment()
            } else -> {
                ThirdFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    fun addTitle(str: String) {
        tabTitle.add(str)
    }

    override fun getPageTitle(position: Int): CharSequence? {
//        return when (position) {
//            0 -> "First Tab"
//            1 -> "Second Tab"
//            else -> "Third Tab"
//        }

        return tabTitle[position]

//        return null
    }

}