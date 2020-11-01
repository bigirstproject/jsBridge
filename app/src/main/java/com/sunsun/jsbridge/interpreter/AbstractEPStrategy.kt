package com.sunsun.jsbridge.interpreter

import android.os.Bundle
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import java.io.Serializable

abstract class AbstractEPStrategy : IEPStrategy {

    companion object {
        /**
         * 四种基础key
         */
        const val TYPE = "type"
        const val EVENT = "event"
        const val DATA = "data"
        const val CALLBACK = "callback"
    }


    override fun getParameter(data: JsonObject?, key: String): JsonElement? {
        return try {
            data?.get(key)
        } catch (ex: Exception) {
            null
        }
    }

    override fun getBundle(data: JsonObject?): Bundle {
        var mBundle = Bundle()
        if (data == null) {
            return mBundle
        }

        for (set in data.entrySet()) {
            try {
                mBundle.putString(set.key, set.value.toString())
            } catch (ex: java.lang.Exception) {
            }
        }
        return mBundle

    }

    data class ProtocolJsonData(val type: String = "", val event: String = "", val data: JsonObject? = null, val callback: String? = null) : Serializable
}