package com.hyt.base_lib.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.blankj.utilcode.util.ToastUtils
import com.dylanc.viewbinding.inflateBindingWithGeneric
import com.hyt.base_lib.R
import com.hyt.base_lib.interfaceA.InformListener
import com.hyt.tool_lib.utils.L
import com.permissionx.guolindev.PermissionX
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class BaseActivity<VB: ViewBinding>: AppCompatActivity() {

    lateinit var binding: VB
    val TAG = javaClass.simpleName

    lateinit var forceOfflineReceiver: ForceOfflineReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateBindingWithGeneric(layoutInflater)
        //控制自主主题
       // setTheme(R.style.Theme_MyAppTheme)
        setContentView(binding.root)
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
        initViews()

        L.d("Hyttt","this:" + this)
        L.d("Hyttt","this:" + this@BaseActivity)
    }

    abstract fun initViews()

    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter().apply {
            addAction("android.PunchApp.forceOfflineReceiver")
        }
        forceOfflineReceiver = ForceOfflineReceiver()
        registerReceiver(forceOfflineReceiver,intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(forceOfflineReceiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }

    // **************************************************************************

    //处理eventBug事件
    @Subscribe(threadMode = ThreadMode.POSTING)
    open fun onMessageEventPosting(eventBusDataBean: EventBusDataBean){
        L.d(TAG,"EventBug-> 接收到消息id:${eventBusDataBean.getEventId()}")

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

    inner class ForceOfflineReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {

            ToastUtils.showLong("收到广播 - ForceOfflineReceiver")

        }

    }


}