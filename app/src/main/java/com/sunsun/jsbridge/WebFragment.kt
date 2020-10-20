package com.sunsun.jsbridge

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

open class WebFragment : Fragment() {

    companion object {
        const val WEB_URL = "web_url"
        const val WITH_TITLE = "with_title"
    }

    lateinit var mUrl: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle = getArguments();
        mUrl = bundle?.getString(WEB_URL).toString();
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


//     fun addJsBridge() {
//        //龙猫协议
//        val jsBridge = mWebView?.let { XDJSBridge(this, it) }
//        mWebView?.addJavascriptInterface(jsBridge, XDJSBridge.JS_OBJECT_NAME)
//    }
//

}