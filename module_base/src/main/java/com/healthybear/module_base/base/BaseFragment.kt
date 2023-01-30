package com.healthybear.module_base.base

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * @author: 郭健鸿
 * @Date: 2023-01-12 01:33
 * @Description:
 */
open class BaseFragment: Fragment() {
    protected val TAG = javaClass::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}