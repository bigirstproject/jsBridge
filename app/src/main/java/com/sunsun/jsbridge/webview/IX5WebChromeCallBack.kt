package com.sunsun.jsbridge.webview;

import android.net.Uri
import com.tencent.smtt.export.external.interfaces.ConsoleMessage
import com.tencent.smtt.sdk.ValueCallback
import com.tencent.smtt.sdk.WebChromeClient

interface IX5WebChromeCallBack {

    fun onProgressChanged(progress: Int)

    fun onReceivedTitle(title: String)

    fun onOpenFileChooserCallBack(uploadMsg: ValueCallback<Uri>, acceptType: String)

    fun onConsoleMessage(consoleMessage: ConsoleMessage)

    fun onShowFileChooserCallBack(filePathCallback: ValueCallback<Array<Uri>>, fileChooserParams: WebChromeClient.FileChooserParams)
}