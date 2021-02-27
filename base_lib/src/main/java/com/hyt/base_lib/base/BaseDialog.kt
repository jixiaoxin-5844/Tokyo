package com.hyt.base_lib.base

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.inflateBindingWithGeneric

//class BaseDialog <VB : ViewBinding>(context: Context, themeResId: Int) : Dialog(context, themeResId) {
open class BaseDialog <VB : ViewBinding>(context: Context) : Dialog(context) {
    lateinit var binding: VB

   // constructor(context: Context) : this(context, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBindingWithGeneric(layoutInflater)
        setContentView(binding.root)
    }
}