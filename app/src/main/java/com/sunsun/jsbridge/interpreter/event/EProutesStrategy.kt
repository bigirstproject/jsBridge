package com.sunsun.jsbridge.interpreter.event

import com.tencent.smtt.sdk.WebView
import com.sunsun.annotation.MyEventType
import com.sunsun.jsbridge.interpreter.AbstractEPStrategy


/**
 * ${路由事件协议处理类}
 */
object EProutesStrategy : AbstractEPStrategy() {
    private const val TYPE = "routes"

    /**
     * event
     */
    //H5
    @MyEventType(type = TYPE)
    private const val EVENT_WEB = "web"

    //原生
    @MyEventType(type = TYPE)
    private const val EVENT_NATIVE = "native"

    //CMS
    @MyEventType(type = TYPE)
    private const val EVENT_CMS = "cms"


    override fun analyzeJson(jsonBean: ProtocolJsonData, webview: WebView, container: Any?) {
        var data = jsonBean.data

        val title = getParameter(data, EPConstant.PARAMETERS_TITLE)?.asString
        val url = getParameter(data, EPConstant.PARAMETERS_URL)?.asString
        val needLogin = getParameter(data, EPConstant.PARAMETERS_NEED_LOGIN)?.asBoolean
//        if (needLogin == true && !AccountHelper.isLogin()) {
//            ActivityHelper.showLoginActivity(activity)
//            return
//        }

        //移除使用过的参数，阻止透传下去
        val bundle = getBundle(data)
        bundle.remove(EPConstant.PARAMETERS_URL)
        bundle.remove(EPConstant.PARAMETERS_TITLE)
        bundle.remove(EPConstant.PARAMETERS_NEED_LOGIN)

//        activity.let {
//            when (jsonBean.event) {
//                EVENT_NATIVE -> {
//                    when(url){
//                        "home_main"->{//首页
//                            EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_REFRESH_REPAYMENT, null))
//                            val mBundle = Bundle()
//                            mBundle.putInt("bundle_index", 0)
//                            RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_HOME, mBundle, Intent.FLAG_ACTIVITY_CLEAR_TOP, null)
//                        }
//                        "bankcard"->{//银行卡
//                            RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_MY_BANKCARD)
//                        }
//                        "home_bill"->{//账单
//                            EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_REFRESH_REPAYMENT, null))
//                            val mBundle = Bundle()
//                            mBundle.putInt("bundle_index", 1)
//                            RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_HOME, mBundle, Intent.FLAG_ACTIVITY_CLEAR_TOP, null)
//                        }
//                        "home_user"->{//个人中心
//                            EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_REFRESH_REPAYMENT, null))
//                            val mBundle = Bundle()
//                            mBundle.putInt("bundle_index", 2)
//                            RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_HOME, mBundle, Intent.FLAG_ACTIVITY_CLEAR_TOP, null)
//                        }
//                    }
//
//                }
////                EVENT_CMS -> {
////                    PRouter.getInstance().build(PageCodeConstant.PAGE_CODE_COMMON_CMS).with(bundle)
////                            .withString(CommonCMSActivity.PAGE_CODE, url ?: "").navigate(it)
////                }
//                EVENT_WEB -> {
//                    if (needLogin == true && !AccountHelper.isLogin()) {
//                        ActivityHelper.showLoginActivity(activity)
//                        return
//                    }
//                    val params = url?.let { it1 -> WebViewParams("", it1) }
//                    ActivityHelper.showWebActivity(params)
//                }
//                else -> {
//                }
//            }
//        }
    }
}