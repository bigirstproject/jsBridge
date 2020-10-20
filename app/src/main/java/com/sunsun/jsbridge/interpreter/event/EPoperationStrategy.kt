package com.sunsun.jsbridge.interpreter.event

import android.webkit.WebView
import com.sunsun.annotation.MyEventType
import com.sunsun.jsbridge.interpreter.AbstractEPStrategy


/**
 * ${操作事件处理类}
 * @author lixiuxian
 * @date 2019-08-14
 */
object EPoperationStrategy : AbstractEPStrategy() {
    private const val TYPE = "operation"
    /**
     * event
     */
    //认证
    @MyEventType(type = TYPE)
    private const val EVENT_VERIFY = "verify"
    //调用JS方法
    @MyEventType(type = TYPE)
    private const val EVENT_CALL_JS = "callJS"
    //拨打电话
    @MyEventType(type = TYPE)
    private const val EVENT_CALL = "call"
    //支付
    @MyEventType(type = TYPE)
    private const val EVENT_PAY = "pay"
    //埋点
    @MyEventType(type = TYPE)
    private const val EVENT_BURY = "bury"
    //微信行为
    @MyEventType(type = TYPE)
    private const val EVENT_WECHAT = "wechat"
    //网络请求透传
    @MyEventType(type = TYPE)
    private const val EVENT_PASS_THROUGH = "passThrough"
    //登出
    @MyEventType(type = TYPE)
    private const val EVENT_LOGOUT = "logout"
    //登录
    @MyEventType(type = TYPE)
    private const val EVENT_LOGIN = "login"
    //页面关闭
    @MyEventType(type = TYPE)
    private const val EVENT_CLOSE = "close"
    //页面返回
    @MyEventType(type = TYPE)
    private const val EVENT_BACK = "back"
    //点击还款
    @MyEventType(type = TYPE)
    private const val EVENT_SEND_SEA_TRACK = "sendSeaTrack"
    //借款页面借一笔分发
    @MyEventType(type = TYPE)
    private const val EVENT_ACTIVE_HOMECARD = "activeHomeCard"
    //日历操作
    @MyEventType(type = TYPE)
    private const val EVENT_UPDATE_CALENDAR = "updateCalendar"

    override fun analyzeJson(jsonBean: ProtocolJsonData, webview: WebView, container: Any?) {
        var data = jsonBean.data
        when (jsonBean.event) {
//            EVENT_VERIFY -> {
//                //todo 认证逻辑
//
//            }
//            EVENT_CALL_JS -> {
//                webview?.post {
//                    webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback, data.toString()))
//                }
//            }
//            EVENT_CALL -> {
//                val phoneNum = getParameter(data, EPConstant.PARAMETERS_PHONE)?.asString
//                PhoneUtil.startCallPhone(activity, phoneNum)
//            }
//            EVENT_PAY -> {
//                //todo 支付逻辑
//            }
            EVENT_UPDATE_CALENDAR ->{
//                EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_UPDATE_CALENDAR, jsonBean))
            }
            EVENT_SEND_SEA_TRACK ->{
//                EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_SEND_SEA_TRACK, data))
            }
            EVENT_BURY -> {
//                try {
//                    val buriedEvent = getParameter(data, EPConstant.PARAMETERS_KEY)?.asString
//                    val buriedParames = getParameter(data, EPConstant.PARAMETERS_PARAMES)
//                    val buriedParamesMap = JsonUtil.getInstance().parseJsonStrToObj(buriedParames?.toString(), Map::class.java)
//                    SensorsManager.track(SensorsKeyDef.KEY_H5_EVENT, Gson().toJson(buriedParamesMap))
//                    buriedEvent.let {
//                        SensorsManager.track(it!!, buriedParamesMap)
//                    }
//                }catch (e:Exception){
//                    e.printStackTrace()
//                }
            }
//            EVENT_WECHAT -> {
//                val type = getParameter(data, EPConstant.PARAMETERS_TYPE)?.asString
//                val typeOpen = "open"
//                val typeSubscription = "subscription"
//                val typeAuthority = "authority"
//                when (type) {
//                    typeOpen -> {
//                        activity?.let {
//                            val name = getParameter(data, EPConstant.PARAMETERS_NAME)?.asString
//                            val clipboardManager = activity.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
//                            clipboardManager.primaryClip = ClipData.newPlainText("Public_Account", name)
//                            try {
//                                val intent = Intent(Intent.ACTION_MAIN)
//                                val cmp = ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI")
//                                intent.addCategory(Intent.CATEGORY_LAUNCHER)
//                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//                                intent.component = cmp
//                                activity.startActivity(intent)
//                            } catch (e: ActivityNotFoundException) {
//                                ToastUtil.showToast(activity, "检查到您手机没有安装微信，请安装后使用该功能")
//                            }
//                        }
//
//                    }
//                    typeSubscription -> {
//                        activity?.let { WechatUtil.oneTimeSubscription(it) }
//                    }
//                    typeAuthority -> {
//                        activity?.let {
//                            WechatUtil.wechatAuthorize(object : WechatUtil.WechatAuthorizeCallback {
//                                override fun onComplete(map: MutableMap<String, String>?) {
//                                    if (map != null) {
//                                        val unionID = map["unionid"]
//                                        //获取成功获取微信Uid
//                                        webview?.post(Runnable {
//                                            val dataMap = HashMap<String, Any?>(2)
//                                            dataMap["unionid"] = unionID!!
//                                            dataMap["phone"] = AccountHelper.getUserPhone()
//                                            val jsonObject = org.json.JSONObject(dataMap)
//                                            webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback,
//                                                    jsonObject.toString()))
//                                        })
//                                    }
//                                }
//
//                                override fun onCancel() {
//                                    ToastUtil.showToast(it, "取消授权")
//                                }
//
//                                override fun onError(throwable: Throwable?) {
//                                    if (throwable != null) {
//                                        ToastUtil.showToast(it, throwable.message)
//                                    }
//                                }
//
//                                override fun onStart() {
//                                }
//                            })
//                        }
//                    }
//
//                }
//            }
//            EVENT_PASS_THROUGH -> {
//                webview?.let {
//                    val networkBean = Gson().fromJson<TotoroJsNativeNetworkBean>(data, object : TypeToken<PassThroughDataBean>() {}.type)
//                    val reqStr = JsonUtil.getInstance().parseObjToJsonStr(networkBean.data!!.params)
//                    val reqMap = JsonUtil.getInstance().parseJsonStrToObj(reqStr, Map::class.java)
//                    TotoroNativeNetworkRequest().tryPostNativeReq(HttpUrls.getsConfigServerUrl() + networkBean.data.url!!, reqMap!! as Map<String, String>,
//                            object : IHttpBizCallBack<String>() {
//                                override fun onSuccess(code: Int, bean: String) {
//                                    webview.post(Runnable { webview.loadUrl(JavaCallJsManager.tryGetJsFunction(networkBean.data.success, bean)) })
//                                }
//
//                                override fun onFailure(errorStr: String, code: Int, bean: String) {
//                                    super.onFailure(errorStr, code, bean)
//                                    webview.post(Runnable {
//                                        try {
//                                            val mBuild = StringBuilder()
//                                            mBuild.append("{\"code\":")
//                                            mBuild.append(code)
//                                            mBuild.append(",\"data\":")
//                                            mBuild.append(bean)
//                                            mBuild.append(",\"msg\":\"")
//                                            mBuild.append(errorStr)
//                                            mBuild.append("\"}")
//                                            val tempData = JavaCallJsManager.tryGetJsFunction(networkBean.data.failureEx, mBuild.toString())
//                                            webview.loadUrl(tempData)
//                                        } catch (e: Exception) {
//                                            e.printStackTrace()
//                                        }
//                                    })
//
//                                }
//
//                                override fun onFailure(errorStr: String, code: Int) {
//                                    webview.post(Runnable {
//                                        val tempData = JavaCallJsManager.tryGetJsFunction(networkBean.data.failure, errorStr)
//                                        webview.loadUrl(tempData)
//                                    })
//                                }
//                            })
//                }
//            }
            EVENT_LOGOUT -> {

            }
            EVENT_LOGIN -> {
                handleLogout()
//                ActivityHelper.showLoginActivity(StackManager.getInstance().currentActivity())
            }
            EVENT_CLOSE -> {
//                StackManager.getInstance().finishActivity()
            }
            EVENT_BACK -> {
                webview?.post {
                    webview.goBack()
                }
            }
            EVENT_ACTIVE_HOMECARD ->{
//                when (AccountHelper.getBizStatus()) {
//                    1 -> { //未实名跳转实名认证页
//                        RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_PRE_CREDIT)
//                    }
//                    2 -> {  //已经实名，小列表
//                        when(AccountHelper.getUserState()){
//                            "040002" ->{ //TODO 额度审核中
//                                val mBundle = Bundle()
//                                mBundle.putInt("bundle_index", 0)
//                                RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_HOME, mBundle, Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                            }
//                            else->{
//                                RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_CREDIT)
//                            }
//                        }
//
//                    }
//                    else -> {
//                        if (AccountHelper.isHasLimit()) {
////                            val data = Bundle()
////                            data.putInt("productType", AccountHelper.getProducetType().toInt())
////                            RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_GETCASH, data, null, null)
//                            var url = HttpUtils.WEB_URL_LOAN() + AccountHelper.getProducetType()
//                            PPLogUtil.d("HomeFragment","url = "+url)
//                            val params = url?.let { it -> WebViewParams("", it) }
//                            ActivityHelper.showWebActivity(params)
//                        } else {
//                            val mBundle = Bundle()
//                            mBundle.putInt("bundle_index", 0)
//                            EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_REFRESH_REPAYMENT, null))
//                            RouterUtils.prouter(StackManager.getInstance().currentActivity(), PageCodeConstant.PAGE_CODE_HOME, mBundle, Intent.FLAG_ACTIVITY_CLEAR_TOP)
//                        }
//                    }
//                }
            }
        }
    }

    /**
     * {退出登录}
     *
     * @param
     * @return
     * Created by Lixiuxian
     */
    private fun handleLogout() {
        //todo
//        ReportFactory.refreshUserId("")
//        AccountHelper.clearAccessToken()
//        ProgressDialogUtil.closeProgressDialog()
    }

    /**
     * {网络透传数据类}
     *
     * @param
     * @return
     * Created by Lixiuxian
     */
//    data class PassThroughDataBean(val failure: String? = "", val success: String? = "", val url: String? = "", val parames: Any? = null) : Serializable
}