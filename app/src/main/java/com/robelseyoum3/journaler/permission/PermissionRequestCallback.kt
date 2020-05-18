package com.robelseyoum3.journaler.permission

interface PermissionRequestCallback {
    fun onPermissionGranted(permission: List<String>)
    fun onPermissionDenied(permission: List<String>)
}