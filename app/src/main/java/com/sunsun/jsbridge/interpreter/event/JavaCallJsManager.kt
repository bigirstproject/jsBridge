package com.sunsun.jsbridge.interpreter.event


object JavaCallJsManager {
    val JS_START_TAG = "javascript:"

    fun tryGetJsFunction(function: String): String {
        return "$JS_START_TAG$function()"
    }

    fun tryGetJsFunction(function: String, data: String): String {
        return "$JS_START_TAG$function(\'$data\')"
    }

    fun tryGetJsFunction(function: String, data1: String, data2: String): String {
        return "$JS_START_TAG$function($data1,$data2)"
    }

    fun tryGetJsFunction(function: String, data1: String, data2: String, data3: String): String {
        return "$JS_START_TAG$function($data1,$data2,$data3)"
    }

    fun tryGetJsFunction(function: String, vararg data: String): String {
        if (null == data || 0 == data.size) {
            return tryGetJsFunction(
                function
            )
        }
        val sb = StringBuilder()
        sb.append(JS_START_TAG).append(function).append('(')
        for (d in data) {
            sb.append(d).append(',')
        }
        sb.delete(sb.length - 1, sb.length)
        sb.append(')')
        return sb.toString()
    }
}
