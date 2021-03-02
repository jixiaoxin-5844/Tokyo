package com.hyt.punchapp

import android.os.Bundle
import com.hyt.base_lib.base.BaseActivity
import com.hyt.punchapp.databinding.ActivityMainBinding
import com.hyt.tool_lib.utils.L

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val TAG = "Hyttt"

    private lateinit var acc: ACC

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding

        System.arraycopy("",2,"",2,3
        )

       /* lambdaFun("ss"){
            L.d(TAG,"lambdaFun0:$it")
        }*/

        setAcc{
            L.d(TAG,"acc:$it")
        }

        if(::acc.isInitialized){
            acc.xx2("嘿嘿")
        }



    }
    private fun lambdaFun(str:String,length:(String) ->Unit){
        L.d(TAG,"lambdaFun1")
        length.invoke(str)
    }




    fun setAcc(inter:(String) -> Unit){
        L.d(TAG,"接口调用")
        acc = object :ACC{
            override fun xx2(str: String) {
                inter.invoke(str)
            }

            override fun xx3(str: String) {


            }
        }
    }

    fun setAcc(acc: ACC){
        this.acc = acc
    }

}