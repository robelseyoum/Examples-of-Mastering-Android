package com.robelseyoum3.journaler.activity

import android.Manifest
import android.app.Activity
import android.content.Context
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import com.robelseyoum3.journaler.R
import com.robelseyoum3.journaler.permission.PermissionCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

abstract class BaseActivity : PermissionCompatActivity() {

    protected abstract val tag : String
    protected abstract fun getLayout(): Int
    protected abstract fun getActivityTitle(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        setContentView(getLayout())
        setSupportActionBar(toolbar)
        Log.v(tag, "[ ON CREATE]")

//        requestGpsPermissions()
        requestPermissions(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
        )

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

//    private fun requestGpsPermissions(){
//        ActivityCompat.requestPermissions(
//            this,
//            arrayOf(
//                Manifest.permission.ACCESS_FINE_LOCATION,
//                Manifest.permission.ACCESS_COARSE_LOCATION),
//                REQUEST_GPS)
//    }

//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if(requestCode == REQUEST_GPS) {
//            for(grantResult in grantResults){
//                if (grantResult == PackageManager.PERMISSION_GRANTED) { Log.e( tag, String.format( Locale.ENGLISH, "Permission granted [ %d ]", requestCode )) }
//                else { Log.e( tag, String.format( Locale.ENGLISH, "Permission not granted [ %d ]", requestCode ) )
//                }
//            }
//        }
//    }

    companion object {
        val REQUEST_GPS = 0
        private var fontExoBold: Typeface? = null
        private var fontExoRegular: Typeface? = null

        fun applyFonts(view: View, context: Context) {
            var vTag = " "
            if (view.tag is String) {
                vTag = view.tag as String
            }
            when (view) {
                is ViewGroup -> {
                    for (x in 0 until view.childCount - 1) {
                        applyFonts(view.getChildAt(x), context)
                    }
                }
                is Button -> {
                    when (vTag) {
                        context.getString(R.string.tag_font_bold) -> {
                            view.typeface = fontExoBold
                        }
                        else -> {
                            view.typeface = fontExoRegular
                        }
                    }
                }
                is EditText -> {
                    when (vTag) {
                        context.getString(R.string.tag_font_bold) -> {
                            view.typeface = fontExoBold
                        }
                        else -> {
                            view.typeface = fontExoRegular
                        }
                    }
                }
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Log.v(tag, "[ ON POST CREATE ]")
        applyFonts()
    }

    protected fun applyFonts() {
        initFonts()
        Log.v(tag, "Applying fonts [START]")
        val rootView = findViewById<View>(android.R.id.content)
        applyFonts(rootView, this)
        Log.v(tag, "Applying fonts [ END ]")
    }

    private fun initFonts() {
        if (fontExoBold == null) {
            Log.v(tag, "Initializing font [ Ex02-Bold ]")
            fontExoBold = Typeface.createFromAsset(assets, "fonts/Exo2-Bold.ttf")
        }
        if (fontExoRegular == null) {
            Log.v(tag, "Initializing font [ Ex02-Regular ]")
            fontExoRegular = Typeface.createFromAsset(assets, "fonts/Exo2-Regular.ttf")
        }
    }

    fun Activity.getAnimation(animation: Int): Animation =
        AnimationUtils.loadAnimation(this, animation)

    override fun onStart() {
        super.onStart()
        Log.v(tag, "[ ON onStart]")
    }

    override fun onRestart() {
        super.onRestart()
        Log.v(tag, "[ ON onRestart]")
    }

    override fun onResume() {
        super.onResume()
        Log.v(tag, "[ ON onResume]")
        val animation = getAnimation(R.anim.top_to_bottom)
        findViewById<View>(R.id.toolbar).startAnimation(animation)
    }

    override fun onPostResume() {
        super.onPostResume()
        Log.v(tag, "[ ON onPostResume]")
    }

    override fun onPause() {
        super.onPause()
        Log.v(tag, "[ ON onPause]")
        val animation = getAnimation(R.anim.hide_to_top)
        findViewById<View>(R.id.toolbar).startAnimation(animation)
    }

    override fun onStop() {
        super.onStop()
        Log.v(tag, "[ ON onStop]")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(tag, "[ ON onDestroy]")
    }

}