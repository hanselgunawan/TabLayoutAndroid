# Tab Layout for Android

## ViewPager with PagerTabStrip
<img src="https://imgur.com/dNQJjQS.png" width="350px" height="650px" />

```
<androidx.viewpager.widget.ViewPager
   android:id="@+id/vpPager"
   android:layout_width="match_parent"
   android:layout_height="wrap_content">

   <androidx.viewpager.widget.PagerTabStrip
        android:id="@+id/pager_header"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_gravity="top"
        android:paddingBottom="4dp"
        android:paddingTop="4dp" />

</androidx.viewpager.widget.ViewPager>
```

## ViewPager with TabLayout
<img src="https://imgur.com/l19Oe4p.png" width="350px" height="650px" />

**XML**

```
    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabs_main"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:tabMode="fixed"
        app:tabSelectedTextColor="@android:color/holo_red_dark"
        tools:ignore="MissingConstraints"/>

    <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewpager_main"
        android:layout_width="match_parent"
        android:layout_height="0px"
        android:foregroundGravity="center"
        android:paddingStart="24dp"
        android:paddingEnd="12dp"
        app:layout_constraintTop_toBottomOf="@+id/tabs_main"/>
```

**Activity**

```
// setup ViewPager adapter
setupViewPager(viewpager_main)

// setup TabLayout
tabs_main.setupWithViewPager(viewpager_main)
```

## ViewPager with TabLayout + Custom Style

<img src="https://imgur.com/dfmBR8g.png" width="350px" height="650px" />

**styles.xml**

```
    <style name="customTabLayout" parent="Widget.Design.TabLayout">
        <item name="tabIndicatorColor">#FF0081FA</item>
        <item name="tabIndicatorHeight">5dp</item>
    </style>
```

**XML**

```
    <com.google.android.material.tabs.TabLayout
        android:id="@+id/tabs_main"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        style="@style/customTabLayout" <-------------
        app:tabMode="fixed"
        app:tabSelectedTextColor="@android:color/holo_red_dark"
        tools:ignore="MissingConstraints"/>
```

## ViewPager with TabLayout + Icon

<img src="https://imgur.com/GRGnAuN.png" width="350px" height="650px" />

**Activity**

```
    private fun setupTabIcons() {
        tabs_main.getTabAt(0)?.setIcon(R.drawable.ic_one)
        tabs_main.getTabAt(1)?.setIcon(R.drawable.ic_two)
        tabs_main.getTabAt(2)?.setIcon(R.drawable.ic_three)
    }
```

## ViewPager with TabLayout + Icon & Text

<img src="https://imgur.com/Iws4U7n.png" width="350px" height="650px" />

**MyPagerAdapter**

```
    private var tabTitle: ArrayList<String> = arrayListOf()
    private var imageArray: ArrayList<Int> = arrayListOf()
    private var mContext: Context = context
    
    fun addTitle(str: String, myDrawable: Int) {
        tabTitle.add(str)
        imageArray.add(myDrawable)
    }

    override fun getPageTitle(position: Int): CharSequence? {
    
        val image: Drawable = ContextCompat.getDrawable(mContext, imageArray[position])!!
        image.setBounds(0,0, image.intrinsicWidth, image.intrinsicHeight)
        val sb = SpannableString("  " + tabTitle[position])
        val imageSpan = ImageSpan(image, ImageSpan.ALIGN_BOTTOM)
        sb.setSpan(imageSpan, 0,1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        return sb
    }
```

**Activity**

```
        pagerAdapter = MyPagerAdapter(supportFragmentManager, this)
        pagerAdapter.addTitle("ONE", R.drawable.ic_one)
        pagerAdapter.addTitle("TWO", R.drawable.ic_two)
        pagerAdapter.addTitle("THREE", R.drawable.ic_three)
        viewPager.adapter = pagerAdapter
```

## ViewPager with Visible Adjacent Pages

<img src="https://imgur.com/khPgtao.png" width="350px" height="650px" />

**Activity**

```
        viewPager.clipToPadding = false
        viewPager.setPadding(24, 0, 12, 0)
        viewPager.pageMargin = 12
```

**Adapter**

```
    override fun getPageWidth(position: Int): Float {
        return 0.93f
    }
```

**XML**

```
    <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewpager_main"
        android:layout_width="match_parent"
        android:layout_height="0px"
        android:foregroundGravity="center"
        android:paddingStart="24dp"
        android:paddingEnd="12dp"
        app:layout_constraintTop_toBottomOf="@+id/tabs_main"/>
```

## ViewPager with ToxicBakery Page Transformer

<img src="https://i.gyazo.com/297d47ee46f4793f5aed437c3be001b2.gif" width="350px" height="650px" />

**build.gradle**

```
implementation 'com.ToxicBakery.viewpager.transforms:view-pager-transforms:1.2.32@aar'
```

**Activity**

```
viewPager.setPageTransformer(true, RotateUpTransformer())
```

## ViewPager with Spring Indicator

<img src="https://i.gyazo.com/297d47ee46f4793f5aed437c3be001b2.gif" width="350px" height="650px" />

**build.gradle**

```
implementation 'com.github.chenupt.android:springindicator:1.0.2@aar'
```

**XML**

```
<github.chenupt.springindicator.SpringIndicator
    xmlns:app="http://schemas.android.com/apk/res-auto"
    app:siTextSize="12sp"
    app:siTextColor="@color/colorPrimaryDark"
    app:siSelectedTextColor="@android:color/white"
    app:siIndicatorColor="@color/colorPrimary"
    android:id="@+id/tabs_main"
    android:layout_width="match_parent"
    android:layout_height="56dp"
    tools:ignore="MissingConstraints" />
```

**Activity**

```
tabs_main.setViewPager(viewpager_main)
```

## ViewPager with Circle Indicator

<img src="https://i.gyazo.com/0e4f257b1731fa3493f4ba8133b5fd8f.gif" width="350px" height="650px" />

**build.gradle**

```
implementation 'me.relex:circleindicator:2.1.4'
```

**XML**

```
<me.relex.circleindicator.CircleIndicator
    android:id="@+id/tabs_main"
    android:layout_width="match_parent"
    android:layout_height="48dp"
    app:ci_drawable="@drawable/black_radius"
    tools:ignore="MissingConstraints" />
```

**Activity**

```
val indicator: CircleIndicator = findViewById(R.id.tabs_main)
indicator.setViewPager(viewpager_main)
```

## ViewPager with Ink Indicator

<img src="https://i.gyazo.com/fbbb7b53c8a20b284bee16a709c88712.gif" width="350px" height="650px" />

**build.gradle**

```
implementation 'com.pacioianu.david:ink-page-indicator:1.3.0'
```

**XML**

```
<com.pixelcan.inkpageindicator.InkPageIndicator
    android:id="@+id/tabs_main"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:ipi_dotDiameter="8dp"
    app:ipi_dotGap="8dp"
    app:ipi_animationDuration="320"
    app:ipi_pageIndicatorColor="@android:color/darker_gray"
    app:ipi_currentPageIndicatorColor="@android:color/black"
    tools:ignore="MissingConstraints" />
```

**Activity**

```
val inkPageIndicator: InkPageIndicator = findViewById(R.id.tabs_main)
inkPageIndicator.setViewPager(viewpager_main)
```
