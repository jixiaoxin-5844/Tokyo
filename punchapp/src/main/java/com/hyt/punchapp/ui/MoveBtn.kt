package com.hyt.punchapp.ui

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import com.hyt.punchapp.R
import com.hyt.tool_lib.utils.L

class MoveBtn : ConstraintLayout {
    private lateinit var image: ImageView

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
            context, attrs, defStyleAttr
    )

    @SuppressLint("ClickableViewAccessibility")
    private fun initView(context: Context) {
        val inflate = LayoutInflater.from(context).inflate(R.layout.view_movebtn, this, true)




        image = inflate.findViewById<ImageView>(R.id.image)
        image.setOnClickListener {

        }
        image.setOnLongClickListener {
            true
        }
        image.setOnTouchListener { v, event ->
            onTouchEvent(event)
        }

    }

    private var lastX = 0
    private var lastY = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        //获取手指触摸点的横坐标和纵坐标
        val x = event.x.toInt()
        val y = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                lastX = x
                lastY = y
            }
            MotionEvent.ACTION_MOVE -> {
                //计算移动距离
                val offsetX = x - lastX
                val offsetY = y - lastY
                //更新位置
                layout(left + offsetX, top + offsetY, right + offsetX, bottom + offsetY)
            }
            MotionEvent.ACTION_UP -> {
                //判断回调click还是LongClick

                if (event.eventTime - event.downTime <= 650) {
                    image.performClick()
                } else {
                    image.performLongClick()
                }

            }

        }
        return true
    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(ev)
    }
}