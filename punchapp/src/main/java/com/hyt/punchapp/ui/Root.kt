package com.hyt.punchapp.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintLayout

class Root: ConstraintLayout {

    constructor(context: Context) : super(context){initView(context)}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){initView(context)}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
            context, attrs, defStyleAttr
    )

    private fun initView(context: Context) {


    }

/*    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return true
    }*/


}