package com.sunsun.jsbridge.interpreter.event

import android.webkit.WebView
import com.sunsun.annotation.MyEventType
import com.sunsun.jsbridge.interpreter.AbstractEPStrategy


/**
 * ${获取信息事件处理类}
 */
object EPgetSomethingStrategy : AbstractEPStrategy() {
    private const val TYPE = "getSomething"
    /**
     * event
     */
    //获取保存后的通讯录地址
    @MyEventType(type = TYPE)
    private const val EVENT_GET_CONTRACT_BY_URL = "getContactByUrl"
    //获取通讯录讯息
    @MyEventType(type = TYPE)
    private const val EVENT_GET_CONTRACT_INFO = "getContactInfo"
    //获取反欺诈信息
    @MyEventType(type = TYPE)
    private const val EVENT_GET_ANTI_FRAUD_INFO = "getAntiFraudInfo"
    //获取用户信息
    @MyEventType(type = TYPE)
    private const val EVENT_GET_USER_INFO = "getUserInfo"
    //获取APP信息
    @MyEventType(type = TYPE)
    private const val EVENT_GET_APP_INFO = "getAppInfo"
    //获取可用事件列表
    @MyEventType(type = TYPE)
    private const val EVENT_GET_JS_FUNCTION_INFO = "getJsFunctionInfo"
    //获取所有可用方法
    @MyEventType(type = TYPE)
    private const val EVENT_GET_USABLE_FUNC = "getUsableFunc"
    //获取登录信息
    @MyEventType(type = TYPE)
    private const val EVENT_GET_LOGIN_INFO = "getLoginInfo"
    //获取业务数据
    @MyEventType(type = TYPE)
    private const val EVENT_GET_BUSINESS_INFO = "getBusinessInfo"
    //获取地理位置信息
    @MyEventType(type = TYPE)
    private const val EVENT_GET_LOCATION_INFO = "getLocationInfo"

    //获取地理位置信息
    @MyEventType(type = TYPE)
    private const val EVENT_GET_AUTHORIZATION = "getAuthorization"


    //日历入口状态
    @MyEventType(type = TYPE)
    private const val EVENT_GET_CALENDAR = "getCalendarSwitch"


    override fun analyzeJson(jsonBean: ProtocolJsonData, webview: WebView, container: Any?) {

        when (jsonBean.event) {
            EVENT_GET_CONTRACT_BY_URL -> {
//                EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_GET_CONTACTURL, jsonBean))
            }
            EVENT_GET_CONTRACT_INFO -> {
//                EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_GET_CONTACTINFO, jsonBean))
            }
            EVENT_GET_ANTI_FRAUD_INFO -> {

            }
            EVENT_GET_AUTHORIZATION -> {
//                var camera = if (EasyPermissions.hasPermissions(StackManager.getInstance().currentActivity(), Manifest.permission.CAMERA)) 1 else 0
//                var calendar = if (EasyPermissions.hasPermissions(StackManager.getInstance().currentActivity(), Manifest.permission.WRITE_CALENDAR)) 1 else 0
//                var contact = if (EasyPermissions.hasPermissions(StackManager.getInstance().currentActivity(), Manifest.permission.READ_CONTACTS)) 1 else 0
//                var location = if (EasyPermissions.hasPermissions(StackManager.getInstance().currentActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) 1 else 0
//                var microphone = if (EasyPermissions.hasPermissions(StackManager.getInstance().currentActivity(), Manifest.permission.RECORD_AUDIO)) 1 else 0
//                var notification = 1
//
//                val bean = AuthorizationStateBean(camera, calendar, contact, location, microphone, notification)
//                val result = EventProtocolUtil.getProtocolUtil(CODE_H5_SUCCESS,"成功",bean)
//                val data = WebViewHelper.tryGetJsFunction(jsonBean.callback, result)
//                WebViewHelper.safeLoadUrl(StackManager.getInstance().currentActivity(), webview, data)
            }
            EVENT_GET_USER_INFO -> {
//                val map = HashMap<String, Any?>()
//                map["b"] = B_VALUE
//                map["u"] = AccountHelper.getUserId()
//                map["token"] = AccountHelper.getUserToken()
//                map["c"] = C_VALUE
//                map["ch"] = AccountHelper.geSubChannelCode()
//                map["appver"] = SystemUtil.getAppInfo().versionName
//                map["channelSub"] = CHANNEL_SUB_VALUE.toInt()
//                map["phone"] = AccountHelper.getUserPhone()
//                map["userGid"] = AccountHelper.getUserGid()
//                map["t"] = AccountHelper.getUserToken()
//                map["distinctId"] = SensorsManager.distinctId
//                map["bizStatus"] = AccountHelper.getBizStatus()
//                val result = EventProtocolUtil.getProtocolUtil(CODE_H5_SUCCESS, "成功", map)
//                webview.post {
//                    webview.loadUrl(WebViewHelper.tryGetJsFunction(jsonBean.callback, result))
//                }
            }
            EVENT_GET_APP_INFO -> {
//                val deviceInfo = SystemUtil.getDeviceInfo()
//                val map = HashMap<String, Any?>(14)
//                map["os"] = "android"
//                map["phone"] = AccountHelper.getUserPhone()
//                map["version"] = Build.VERSION.RELEASE
//                map["appVersion"] = SystemUtil.getAppInfo().versionName
//                map["deviceId"] = deviceInfo.deviceId
//                map["network"] = NetworkUtil.getNetworkTypeName()
//                map["width"] = DisplayUtil.getWindowWidth(container as Activity)
//                map["height"] = DisplayUtil.getWindowHeight(container)
//                map["model"] = deviceInfo.deviceName
//                map["imei"] = deviceInfo.imei
//                map["macAdr"] = deviceInfo.macAdr
//                map["simNo"] = deviceInfo.simNo
//                map["isHack"] = deviceInfo.hacked
//                map["channel"] = SystemUtil.getChannel(container)
//                val result = EventProtocolUtil.getProtocolUtil(CODE_H5_SUCCESS, "成功", map)
//                webview.post {
//                    webview.loadUrl(WebViewHelper.tryGetJsFunction(jsonBean.callback, result))
//                }

            }
            EVENT_GET_JS_FUNCTION_INFO -> {
//                var array = JsonArray()
//                try {
//                    var funcMap = EventTypeMap.eventTypeMap
//                    var jsonArray = data?.get("functions")?.asJsonArray
//                    jsonArray?.let {
//                        for (json in jsonArray) {
//                            val jo = json.asJsonObject
//                            val type = jo.get("type").asString
//                            val event = jo.get("event").asString
//                            if (funcMap.containsKey(Pair(type, event))) {
//                                jo.addProperty("capable", true)
//                                array.add(jo)
//                            } else {
//                                jo.addProperty("capable", false)
//                                array.add(jo)
//                            }
//                        }
//                    }
//                } catch (ex: Exception) {
//
//                } finally {
//                    webview?.post {
//                        webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback, array.toString()))
//                    }
//                }

            }
            EVENT_GET_USABLE_FUNC -> {
//                var array = JsonArray()
//                try {
//                    var funcMap = EventTypeMap.eventTypeMap
//                    for (item in funcMap) {
//                        var pair = item.key
//                        val jo = JsonObject()
//                        jo.addProperty("type", pair.first)
//                        jo.addProperty("event", pair.second)
//                        array.add(jo)
//                    }
//                } catch (ex: Exception) {
//
//                } finally {
//                    webview?.post {
//                        webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback, array.toString()))
//                    }
//                }
            }

            EVENT_GET_LOGIN_INFO -> {
//                val map = HashMap<String, Any>()
//                map["isLogin"] = AccountHelper.isLogin()
//                webview?.post {
//                    webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback, map))
//                }
            }
            EVENT_GET_BUSINESS_INFO -> {
//                if (jsonBean.callback != null) {
//                    if (fragment != null) {
//                        val businessData = fragment.businessData
//                        webview?.post {
//                            webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback, businessData))
//                        }
//                    }
//                    if (activity != null) {
//                        val businessData = activity.businessData
//                        webview?.post {
//                            webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback, businessData))
//                        }
//                    }
//                }
            }
            EVENT_GET_LOCATION_INFO -> {
                //todo 未整入定位sdk
//                val result = LocationHelper.getInstance().location
//                val map = HashMap<String, Any?>()
//                if (result != null) {
//                    val longitude = BigDecimal.valueOf(result.longitude).setScale(6, RoundingMode.HALF_UP).toFloat().toString() + ""
//                    val latitude = BigDecimal.valueOf(result.latitude).setScale(6, RoundingMode.HALF_UP).toFloat().toString() + ""
//                    map["province"] = result.province
//                    map["city"] = result.city
//                    map["district"] = result.district
//                    map["address"] = result.addrStr
//                    map["longitude"] = longitude
//                    map["latitude"] = latitude
//                    if (result.locType != 61 && result.locType != 161) { //GPS定位成功或者网络定位成功
//                        map["error"] = "获取定位失败"
//                    }
//                } else {
//                    map["error"] = "获取定位失败"
//                }
//                webview?.post {
//                    webview.loadUrl(JavaCallJsManager.tryGetJsFunction(jsonBean.callback, map))
//                }
            }
            EVENT_GET_CALENDAR ->{
//                EventBus.getDefault().post(EventBusParams(EventKeyDef.KEY_GET_CALENDAR, jsonBean))
            }
        }
    }

}