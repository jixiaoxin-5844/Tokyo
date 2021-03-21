package com.hyt.punchapp.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.hyt.punchapp.R

class BottomBtn : ConstraintLayout {

    private lateinit var image: ImageView
    private lateinit var textView: TextView

    constructor(context: Context) : super(context){initView(context)}
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs){initView(context)}
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
            context, attrs, defStyleAttr
    )

    private fun initView(context: Context) {
        val inflate = LayoutInflater.from(context).inflate(R.layout.view_bottom_btn, this, true)
        image = inflate.findViewById<ImageView>(R.id.viewBottom_Img)
        textView = inflate.findViewById<TextView>(R.id.viewBottom_text)


    }

    fun setImage(img: Int){
        if(::image.isInitialized){
            image.setImageResource(img)
        }
    }

    fun setText(text: String){
        if(::textView.isInitialized){
            textView.text = text
        }
    }


}