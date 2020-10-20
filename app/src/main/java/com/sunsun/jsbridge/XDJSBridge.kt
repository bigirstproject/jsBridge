package com.sunsun.jsbridge

import android.webkit.JavascriptInterface
import android.webkit.WebView
import com.sunsun.jsbridge.interpreter.EventProtocolUtil


class XDJSBridge(val container: Any, val mWebView: WebView) {

    companion object {
        const val JS_OBJECT_NAME = "ppmoney"
    }

    @JavascriptInterface
    fun callNative(str: String) {
        mWebView?.post {
            EventProtocolUtil.analyzeJson(str,mWebView, container)
        }
    }

}