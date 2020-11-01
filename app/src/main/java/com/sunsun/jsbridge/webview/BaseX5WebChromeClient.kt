package com.sunsun.jsbridge.webview;

import android.net.Uri
import android.util.Log
import com.tencent.smtt.export.external.interfaces.ConsoleMessage
import com.tencent.smtt.sdk.ValueCallback
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView

class BaseX5WebChromeClient(var callback: IX5WebChromeCallBack) : WebChromeClient() {

    override fun onProgressChanged(view: WebView, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
        callback.onProgressChanged(newProgress)
    }

    override fun onReceivedTitle(view: WebView, title: String) {
        super.onReceivedTitle(view, title)
        callback.onReceivedTitle(title)
    }

    override fun onShowFileChooser(webView: WebView, filePathCallback: ValueCallback<Array<Uri>>, fileChooserParams: FileChooserParams): Boolean {
        callback.onShowFileChooserCallBack(filePathCallback, fileChooserParams)
        return true
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
        callback.onConsoleMessage(consoleMessage)
        Log.i("webview",consoleMessage.message())
        return super.onConsoleMessage(consoleMessage)
    }
}