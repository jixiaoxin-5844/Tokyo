package com.hyt.base_lib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.inflateBindingWithGeneric
import com.hyt.base_lib.interfaceA.InformListener
import com.hyt.tool_lib.utils.L
import com.permissionx.guolindev.PermissionX

open class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    lateinit var binding: VB
    val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBindingWithGeneric(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    open fun initViews() {


    }

    /**
     * @param informListener 结果
     * @param permissions 要请求的权限
     * */
    fun permissionX(informListener: InformListener,vararg permissions: String){
        PermissionX.init(this)
            .permissions(permissions.asList())
            //  .permissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .onExplainRequestReason{ scope, den->
                val message = "需要同意以下权限才能正常使用"
                scope.showRequestReasonDialog(den, message, "确定", "取消")
            }
            .request{ allGranted, _, _ ->
                if (allGranted) {
                    informListener.onSucceed()
                } else {
                    //ToastUtils.show("请授予权限")
                    informListener.onFailure()
                }
            }
    }
}