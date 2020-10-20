package com.sunsun.jsbridge.interpreter.event

import android.webkit.WebView
import com.sunsun.annotation.MyEventType
import com.sunsun.jsbridge.interpreter.AbstractEPStrategy

/**
 * ${UI展示性行为事件处理类}
 */
object EPuiBehaviorsStrategy : AbstractEPStrategy() {
    private const val TYPE = "uiBehaviors"
    /**
     * event
     */
    //分享
    @MyEventType(type = TYPE)
    private const val EVENT_SHARE = "share"
    //通用文本弹窗
    @MyEventType(type = TYPE)
    private const val EVENT_DIALOG = "dialog"
    //图片弹窗
    @MyEventType(type = TYPE)
    private const val EVENT_PIC_DIALOG = "picDialog"
    //弹出消息
    @MyEventType(type = TYPE)
    private const val EVENT_TOAST = "toast"
    //读取Loading
    @MyEventType(type = TYPE)
    private const val EVENT_LOADING_PROGRESS = "loadingProgress"

    override fun analyzeJson(jsonBean: ProtocolJsonData, webview: WebView, container: Any?) {
//        var data = jsonBean.data
//        when (jsonBean.event) {
//            EVENT_SHARE -> {
//                val title = getParameter(data, EPConstant.PARAMETERS_TITLE)?.asString
//                val message = getParameter(data, EPConstant.PARAMETERS_MESSAGE)?.asString
//                val shareImgUrl = getParameter(data, EPConstant.PARAMETERS_SHARE_IMG_URL)?.asString
//                val url = getParameter(data, EPConstant.PARAMETERS_URL)?.asString
//                val activity = StackManager.getInstance().currentActivity()
//                activity?.let {
//                    val builder = ShareEvent.Builder()
//                    builder.setWechatEnable(true)
//                            .setWechatCircleEnable(true)
//                            .setQQEnable(true)
//                            .setQZoneEnable(true)
//                    title?.let { builder.setShareTitle(it) }
//                    message?.let { builder.setShareContent(it) }
//                    shareImgUrl?.let { builder.setShareImgUrl(it) }
//                    url?.let { builder.setShareUrl(it) }
//                    ShareUtil.share(it, builder.build())
//                }
//            }
//
//            EVENT_DIALOG -> {
//                val title = getParameter(data, EPConstant.PARAMETERS_TITLE)?.asString
//                val content = getParameter(data, EPConstant.PARAMETERS_CONTENT)?.asString
//                val confirmText = getParameter(data, EPConstant.PARAMETERS_CONFIRM_TEXT)?.asString
//                val confirmUrl = getParameter(data, EPConstant.PARAMETERS_CONFIRM_URL)?.toString()
//                val cancelText = getParameter(data, EPConstant.PARAMETERS_CANCEL_TEXT)?.asString
//                val cancelUrl = getParameter(data, EPConstant.PARAMETERS_CANCEL_URL)?.toString()
//                val cancelable = getParameter(data, EPConstant.PARAMETERS_CANCELABLE)?.asBoolean
//                val activity = StackManager.getInstance().currentActivity()
//                activity?.let {
//                    DialogUtil.showDialog(activity, "", title ?: "", content ?: "",
//                            confirmText ?: "", cancelText ?: "", object : DialogUtil.DialogClickEventListener {
//                        override fun onLeftClickEvent() {
//                            //confirm
//                            EventProtocolUtil.analyzeJson(confirmUrl ?: "", container)
//                        }
//
//                        override fun onRightClickEvent() {
//                            //cancel
//                            EventProtocolUtil.analyzeJson(cancelUrl ?: "", container)
//                        }
//
//                        override fun onPicClickEvent() {
//                            //pic click - no need to focus in this call back
//                        }
//
//                        override fun onCloseClickEvent() {
//                            //close click - no need to focus in this call back
//                        }
//                    }, cancelable ?: false)
//                }
//            }
//
//            EVENT_PIC_DIALOG -> {
//                val picUrl = getParameter(data, EPConstant.PARAMETERS_PIC_URL)?.asString
//                val url = getParameter(data, EPConstant.PARAMETERS_URL)?.toString()
//                val cancelable = getParameter(data, EPConstant.PARAMETERS_CANCELABLE)?.asBoolean
//                val activity = StackManager.getInstance().currentActivity()
//                activity?.let {
//                    DialogUtil.showDialog(activity, picUrl ?: "", "", "",
//                            "", "", object : DialogUtil.DialogClickEventListener {
//                        override fun onLeftClickEvent() {
//                            //confirm - no need to focus in this call back
//                        }
//
//                        override fun onRightClickEvent() {
//                            //cancel - no need to focus in this call bcak
//                        }
//
//
//                        override fun onPicClickEvent() {
//                            //pic click
//                            EventProtocolUtil.analyzeJson(url ?: "", container)
//                        }
//
//                        override fun onCloseClickEvent() {
//                            //close click
//                        }
//                    }, cancelable ?: false)
//                }
//            }
//
//            EVENT_TOAST -> {
//                val message = getParameter(data, EPConstant.PARAMETERS_MESSAGE)?.asString
//                if (!message.isNullOrEmpty()) {
//                    val activity = StackManager.getInstance().currentActivity()
//                    activity?.toast(message)
//                }
//            }
//
//            EVENT_LOADING_PROGRESS -> {
//                val isShow = getParameter(data, EPConstant.PARAMETERS_IS_SHOW)?.asBoolean
//                val cancelable = getParameter(data, EPConstant.PARAMETERS_CANCELABLE)?.asBoolean
//
//                var currentActivity = StackManager.getInstance().currentActivity()
//                currentActivity?.let {
//                    if (isShow ?: false)
//                        ProgressDialogUtil.showProgressDialog(it, "", cancelable ?: false)
//                    else
//                        ProgressDialogUtil.closeProgressDialog()
//                }
//            }
//        }

    }

}