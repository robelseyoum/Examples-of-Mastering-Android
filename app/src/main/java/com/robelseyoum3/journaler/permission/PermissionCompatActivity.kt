package com.robelseyoum3.journaler.permission

import android.content.pm.PackageManager
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicInteger

abstract class PermissionCompatActivity : AppCompatActivity() {
    private val tag = "Permissions extension"
    private val latestPermissionRequest = AtomicInteger()
    private val permissionRequest = ConcurrentHashMap<Int, List<String>>()

    private val permissionCallbacks = ConcurrentHashMap<List<String>, PermissionRequestCallback>()

    private val defaultPermissionRequestCallback = object : PermissionRequestCallback {
        override fun onPermissionGranted(permission: List<String>) {
            Log.i(tag, "Permission granted [ $permission ]")
        }

        override fun onPermissionDenied(permission: List<String>) {
            Log.i(tag, "Permission granted [ $permission ]")
        }

    }

    fun requestPermissions(
        vararg permissions: String,
        callback: PermissionRequestCallback = defaultPermissionRequestCallback
    ) {
        val id = latestPermissionRequest.incrementAndGet()
        val items = mutableListOf<String>()
        items.addAll(permissions)
        permissionRequest[id] = items
        permissionCallbacks[items] = callback
        ActivityCompat.requestPermissions(this, permissions, id)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        val items = permissionRequest[requestCode]
        items?.let {
            val callback = permissionCallbacks[items]
            callback?.let {
                var success = true
                for (x in 0 until grantResults.lastIndex) {
                    val result = grantResults[x]
                    if (result != PackageManager.PERMISSION_GRANTED) {
                        success = false
                        break
                    }
                }
                if (success) {
                    callback.onPermissionGranted(items)
                } else {
                    callback.onPermissionDenied(items)
                }
            }
        }
    }
}