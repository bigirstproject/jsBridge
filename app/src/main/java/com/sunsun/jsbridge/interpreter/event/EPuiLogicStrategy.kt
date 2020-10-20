package com.sunsun.jsbridge.interpreter.event

import android.webkit.WebView
import com.sunsun.annotation.MyEventType
import com.sunsun.jsbridge.interpreter.AbstractEPStrategy


/**
 * ${原生改变页面UI逻辑事件处理类}
 */
object EPuiLogicStrategy : AbstractEPStrategy() {
    private const val TYPE = "uiLogic"

    /**
     * event
     */
    //设置返回按钮点击逻辑
    @MyEventType(type = TYPE)
    private const val EVENT_SET_BACKBTN_LOGIC = "setBackBtnLogic"

    //设置右上角点击按钮逻辑
    @MyEventType(type = TYPE)
    private const val EVENT_SET_TOPRIGHTBTN_LOGIC = "setTopRightBtnLogic"

    //设置标题栏属性
    @MyEventType(type = TYPE)
    private const val EVENT_SET_TITLE = "setTitle"

    //设置能否下拉刷新
    @MyEventType(type = TYPE)
    private const val EVENT_SET_REFRESH_ENABLE = "setRefreshEnable"

    //设置能否侧滑返回
    @MyEventType(type = TYPE)
    private const val EVENT_SET_SLIDE_ENABLE = "setSlideEnable"

    override fun analyzeJson(jsonBean: ProtocolJsonData, webview: WebView, container: Any?) {
        var data = jsonBean.data
        when (jsonBean.event) {
            EVENT_SET_BACKBTN_LOGIC -> {
                val url = getParameter(data, EPConstant.PARAMETERS_URL)?.toString()
                val visible = getParameter(data, EPConstant.PARAMETERS_VISIBLE)?.asBoolean

            }
            EVENT_SET_TOPRIGHTBTN_LOGIC -> {
                val url = getParameter(data, EPConstant.PARAMETERS_URL)?.toString()
                val iconUrl = getParameter(data, EPConstant.PARAMETERS_ICON_URL)?.asString
                val visible = getParameter(data, EPConstant.PARAMETERS_VISIBLE)?.asBoolean


            }
            EVENT_SET_TITLE -> {
                val title = getParameter(data, EPConstant.PARAMETERS_TITLE)?.asString
                val titleColor = getParameter(data, EPConstant.PARAMETERS_TITLE_COLOR)?.asString
                val backgroundColor =
                    getParameter(data, EPConstant.PARAMETERS_BACKGROUND_COLOR)?.asString


            }
            EVENT_SET_REFRESH_ENABLE -> {
                //取消刷新
            }
            EVENT_SET_SLIDE_ENABLE -> {
                //取消侧滑
            }
        }
    }
}