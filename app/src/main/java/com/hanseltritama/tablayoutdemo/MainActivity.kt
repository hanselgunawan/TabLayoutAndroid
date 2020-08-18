package com.hanseltritama.tablayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.pixelcan.inkpageindicator.InkPageIndicator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var pagerAdapter: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // setup ViewPager adapter
        setupViewPager(viewpager_main)

        val inkPageIndicator: InkPageIndicator = findViewById(R.id.tabs_main)

        // setup Indicator
        inkPageIndicator.setViewPager(viewpager_main)
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


}
