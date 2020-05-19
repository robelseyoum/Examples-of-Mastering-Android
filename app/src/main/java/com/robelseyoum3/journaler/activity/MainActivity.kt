package com.robelseyoum3.journaler.activity


import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.ViewPager
import com.robelseyoum3.journaler.R
import com.robelseyoum3.journaler.fragment.ItemsFragment
import com.robelseyoum3.journaler.navigation.NavigationDrawerAdapter
import com.robelseyoum3.journaler.navigation.NavigationDrawerItem
import com.robelseyoum3.journaler.preferences.PreferencesConfiguration
import com.robelseyoum3.journaler.preferences.PreferencesProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    private val keyPagePosition = "keyPagePosition"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val provider = PreferencesProvider()
        val config = PreferencesConfiguration("journaler_prefs", Context.MODE_PRIVATE)
        val preferences = provider.obtain(config, this)

        pager.adapter = ViewPagerAdapter(supportFragmentManager)
        val pagerPosition = preferences.getInt(keyPagePosition, 0)
        pager.setCurrentItem(pagerPosition, true)

        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
                //will do it later
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                Log.v(tag, "Page [ $position ]")
                preferences.edit().putInt(keyPagePosition, position).apply()
            }

        })

        val menuItem = mutableListOf<NavigationDrawerItem>()

        val today = NavigationDrawerItem(
            getString(R.string.today),
            Runnable { pager.setCurrentItem(0, true) }
        )

        val next7days = NavigationDrawerItem(
            getString(R.string.next_seven_days),
            Runnable { pager.setCurrentItem(1, true) }
        )

        val todos = NavigationDrawerItem(
            getString(R.string.todos),
            Runnable { pager.setCurrentItem(2, true) }
        )

        val notes = NavigationDrawerItem(
            getString(R.string.notes),
            Runnable { pager.setCurrentItem(3, true) }
        )

        menuItem.add(today)
        menuItem.add(next7days)
        menuItem.add(todos)
        menuItem.add(notes)

        val navigationDrawerAdapter = NavigationDrawerAdapter(this, menuItem)
        left_drawer.adapter = navigationDrawerAdapter
    }

    private class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
      override fun getItem(position: Int): Fragment = ItemsFragment()
      override fun getCount(): Int = 4
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when (item.itemId) {
            R.id.drawing_menu -> {
                drawer_layout.openDrawer(GravityCompat.START)
                return true
            }
            R.id.option_menu -> {
                Log.v(tag, "Option menu.")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override val tag = "Main activity"
    override fun getLayout() = R.layout.activity_main
    override fun getActivityTitle() = R.string.app_name
}
