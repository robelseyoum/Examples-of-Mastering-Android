package com.robelseyoum3.journaler.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    protected abstract val logTag: String
    protected abstract fun getLayout() : Int

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.v(logTag, "[ onCreateView ]")
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.v(logTag, "[ onStart ]")
    }

    override fun onStart() {
        super.onStart()
        Log.v(logTag, "[ onStart ]")
    }

    override fun onPause() {
        super.onPause()
        Log.v(logTag, "[ onPause ]")
    }

    override fun onStop() {
        super.onStop()
        Log.v(logTag, "[ onStop ]")
    }

    override fun onResume() {
        super.onResume()
        Log.v(logTag, "[ onResume ]")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.v(logTag, "[ onDestroy ]")
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Log.v(logTag, "[ onActivityCreated ]")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.v(logTag, "[ onDestroyView ]")
    }
}