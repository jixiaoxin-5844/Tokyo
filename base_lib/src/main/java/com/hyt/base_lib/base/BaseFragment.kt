package com.hyt.base_lib.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.dylanc.viewbinding.inflateBindingWithGeneric
import com.hyt.base_lib.interfaceA.InformListener
import com.hyt.tool_lib.utils.L
import com.permissionx.guolindev.PermissionX
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseFragment<VB: ViewBinding>: Fragment() {

    val TAG = javaClass.simpleName
    private var _binding: VB? = null
    val binding:VB get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = inflateBindingWithGeneric(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViews()
    }

    abstract fun initViews()

    //处理eventBug事件
    @Subscribe(threadMode = ThreadMode.POSTING)
    open fun onMessageEventPosting(eventBusDataBean: EventBusDataBean){
        L.d(TAG,"EventBug-> 接收到消息id:${eventBusDataBean.getEventId()}")

    }

    /**
     * @param informListener 结果
     * @param permissions 要请求的权限
     * */
    fun permissionX(informListener: InformListener, vararg permissions: String){
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}