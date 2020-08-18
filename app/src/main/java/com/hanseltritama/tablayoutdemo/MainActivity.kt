package com.hanseltritama.tablayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var pagerAdapter: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup ViewPager adapter
        setupViewPager(viewpager_main)

        // setup TabLayout
        tabs_main.setupWithViewPager(viewpager_main)

        // setup tab icons
        setupTabIcons()
    }

    private fun setupViewPager(viewPager: ViewPager) {
        pagerAdapter = MyPagerAdapter(supportFragmentManager, this)
        pagerAdapter.addTitle("ONE", R.drawable.ic_one)
        pagerAdapter.addTitle("TWO", R.drawable.ic_two)
        pagerAdapter.addTitle("THREE", R.drawable.ic_three)
        viewPager.clipToPadding = false
        viewPager.setPadding(24, 0, 12, 0)
        viewPager.pageMargin = 12
        viewPager.adapter = pagerAdapter
    }

    private fun setupTabIcons() {
        tabs_main.getTabAt(0)?.setIcon(R.drawable.ic_one)
        tabs_main.getTabAt(1)?.setIcon(R.drawable.ic_two)
        tabs_main.getTabAt(2)?.setIcon(R.drawable.ic_three)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("POSITION", tabs_main.selectedTabPosition)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewpager_main.currentItem = savedInstanceState.getInt("POSITION")
    }


}
