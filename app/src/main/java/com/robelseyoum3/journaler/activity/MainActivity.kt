package com.robelseyoum3.journaler.activity


import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.robelseyoum3.journaler.R
import com.robelseyoum3.journaler.fragment.ItemsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pager.adapter = ViewPagerAdapter(supportFragmentManager)
    }

    private class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {
      override fun getItem(position: Int): Fragment = ItemsFragment()
      override fun getCount(): Int = 4
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
       return when (item.itemId) {
            R.id.drawing_menu -> {
                Log.v(tag, "Main menu.")
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
