package com.sunsun.jsbridge.interpreter.event

import android.webkit.WebView
import com.sunsun.annotation.MyEventType
import com.sunsun.jsbridge.interpreter.AbstractEPStrategy


/**
 * ${原生改变页面UI逻辑事件处理类}
 */
object EPnotificationStrategy : AbstractEPStrategy() {
    private const val TYPE = "uiLogic"
    /**
     * event
     */
    //设置返回按钮点击逻辑
    @MyEventType(type = TYPE)
    private const val EVENT_NOTIFCATION_BASE_INFO = "baseInfo"


    override fun analyzeJson(jsonBean: ProtocolJsonData, webview: WebView, container: Any?) {
        var data = jsonBean.data

//        val activity = StackManager.getInstance().currentActivity()
//        activity.let {
//            when (jsonBean.event) {
//                EVENT_NOTIFCATION_BASE_INFO -> {
//                    EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_REFRESH_BASE_INFO, jsonBean))
//
//                }
//            }
//        }
    }
}