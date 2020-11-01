package com.sunsun.jsbridge.interpreter;

import com.google.gson.Gson
import com.google.gson.JsonObject

/**
 * ${通用事件处理工具类}
 */
object EventProtocolUtil {

    /**
     * {判断jsonStr是否合理}
     *
     * @param jsonStr 协议字符串类型
     * @return 是否符合事件协议
     */
    fun checkRational(jsonStr: String): Boolean {
        //走协议
        return try {
           // val realJsonStr = URLDecoder.decode(jsonStr, "utf-8")
            val jsonObject = Gson().fromJson<JsonObject>(jsonStr, JsonObject::class.java)
            val withType = jsonObject.has(AbstractEPStrategy.TYPE)
            return withType
        } catch (ex: Exception) {
            false
        }
    }

    /**
     * {分析jsonString，分发事件}
     *
     * @param url 事件url
     */
    fun analyzeJson(jsonStr: String, webView: com.tencent.smtt.sdk.WebView, container: Any? = null) {
        try {
            //走协议
            //var realJsonStr = URLDecoder.decode(jsonStr, "utf-8")
            var jsonObject = Gson().fromJson<JsonObject>(jsonStr, JsonObject::class.java)
            //走新协议
            val jsBean = Gson().fromJson<AbstractEPStrategy.ProtocolJsonData>(jsonObject, AbstractEPStrategy.ProtocolJsonData::class.java)
            val kClass = Class.forName("com.sunsun.jsbridge.interpreter.event.EP${jsBean.type}Strategy").kotlin
            val instance = kClass.objectInstance
            if (instance is IEPStrategy) { instance.analyzeJson(jsBean,webView, container)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

    inline fun<T> getProtocolUtil(code:Int,msg:String,data:T):String{
        val result = BaseEventBean<T>()
        result.code = code
        result.message = msg
        result.data = data
        return  Gson().toJson(result)
    }
}