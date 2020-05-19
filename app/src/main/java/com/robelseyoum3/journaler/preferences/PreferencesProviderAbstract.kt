package com.robelseyoum3.journaler.preferences

import android.content.Context
import android.content.SharedPreferences

/**
 *  PreferencesProviderAbstract: This is basic abstraction to provide access to SharedPreferences
 */
abstract class PreferencesProviderAbstract {
    abstract fun obtain(
        configuration: PreferencesConfiguration,
        context: Context
    ): SharedPreferences
}