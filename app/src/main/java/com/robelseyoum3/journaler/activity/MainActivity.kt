package com.robelseyoum3.journaler.activity


import android.os.Bundle
import com.robelseyoum3.journaler.R
import com.robelseyoum3.journaler.fragment.ItemsFragment
import com.robelseyoum3.journaler.fragment.ManualFragment
import kotlinx.android.synthetic.main.activity_header.*

class MainActivity : BaseActivity() {
    override val tag = "Main activity"
    override fun getLayout() = R.layout.activity_main
    override fun getActivityTitle() = R.string.app_name

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragment = ItemsFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
        /**
         * Do you remember the order in which lifecycle methods are executed?
         * You can recognize that each time a new fragment is added to the top, the one below pauses.
         * When we start going back by pressing the back button, the fragment on the top pauses and the one below resumes.
         * Fragments that are removed from the back stack enter the onDestroy() method at the end.
         */
        filter_menu.text = "H"
        filter_menu.setOnClickListener {
            val userManualFragment = ManualFragment()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, userManualFragment)
                .addToBackStack("User manual")
                .commit()
        }
    }
}
