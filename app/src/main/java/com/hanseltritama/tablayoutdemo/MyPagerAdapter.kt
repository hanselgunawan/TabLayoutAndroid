package com.hanseltritama.tablayoutdemo

import android.content.Context
import android.graphics.drawable.Drawable
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ImageSpan
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fragmentManager: FragmentManager, context: Context) : FragmentPagerAdapter(fragmentManager) {

    private var tabTitle: ArrayList<String> = arrayListOf()
    private var imageArray: ArrayList<Int> = arrayListOf()
    private var mContext: Context = context

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

    fun addTitle(str: String, myDrawable: Int) {
        tabTitle.add(str)
        imageArray.add(myDrawable)
    }

    override fun getPageTitle(position: Int): CharSequence? {
//        return when (position) {
//            0 -> "First Tab"
//            1 -> "Second Tab"
//            else -> "Third Tab"
//        }

        // --------- DEPRECATED-----------
        // mContext.resources.getDrawable()
        // -------------------------------

        val image: Drawable = ContextCompat.getDrawable(mContext, imageArray[position])!!
        val sb = SpannableString(" " + tabTitle[position])
        val imageSpan = ImageSpan(image, ImageSpan.ALIGN_BOTTOM)
        sb.setSpan(imageSpan, 0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return sb

//        return null
    }

}