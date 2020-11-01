package com.sunsun.jsbridge.webview;

import android.webkit.JavascriptInterface
import com.sunsun.jsbridge.interpreter.EventProtocolUtil


class XDJSBridge(val container: Any, val mWebView: com.tencent.smtt.sdk.WebView) {

    companion object {
        const val JS_OBJECT_NAME = "test"
    }

    @JavascriptInterface
    fun callNative(str: String) {
        mWebView?.post {
            EventProtocolUtil.analyzeJson(str,mWebView, container)
        }
    }

}