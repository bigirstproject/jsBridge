package com.sunsun.jsbridge.interpreter

import android.os.Bundle
import android.webkit.WebView
import com.google.gson.JsonObject
import com.sunsun.jsbridge.interpreter.AbstractEPStrategy

/**
 * ${策略抽象}
 * @author lixiuxian
 * @date 2019-08-14
 */
interface IEPStrategy {
    /**
     * {分析Json进行处理}
     *
     * @param jsonBean 事件协议
     * @param container 容器（可为空）
     * Created by Lixiuxian
     */
    fun analyzeJson(jsonBean: AbstractEPStrategy.ProtocolJsonData, webview: WebView, container: Any?)

    /**
     * {依据key获取对应参数}
     *
     * @param data 事件参数数据
     * @param key 对应参数的key
     * @return 对应key值所代表的数据
     * Created by Lixiuxian
     */
    fun getParameter(data: JsonObject?, key: String): Any?

    /**
     * {将参数放入bundle中}
     *
     * @param data 事件参数数据
     * @return 添加参数的数据容器集合
     * Created by Lixiuxian
     */
    fun getBundle(data: JsonObject?): Bundle
}