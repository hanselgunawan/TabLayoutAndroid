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

        // setup ViewPager
        setupViewPager(viewpager_main)

        // setup TabLayout
        tabs_main.setupWithViewPager(viewpager_main)

        // setup tab icons
        setupTabIcons()
    }

    fun setupTabIcons() {
        tabs_main.getTabAt(0)?.setIcon(R.drawable.ic_one)
        tabs_main.getTabAt(1)?.setIcon(R.drawable.ic_two)
        tabs_main.getTabAt(2)?.setIcon(R.drawable.ic_three)
    }

    fun setupViewPager(viewPager: ViewPager) {
        pagerAdapter = MyPagerAdapter(supportFragmentManager)
        pagerAdapter.addTitle("ONE")
        pagerAdapter.addTitle("TWO")
        pagerAdapter.addTitle("THREE")
        viewPager.adapter = pagerAdapter
    }
}
