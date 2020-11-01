package com.sunsun.jsbridge.webview;

import android.os.Bundle
import android.view.View
import com.sunsun.jsbridge.utils.EventBusParams
import com.tencent.smtt.export.external.interfaces.ConsoleMessage


open class WebFragment : BaseX5WebFragment() {

    companion object {
        const val WEB_URL = "web_url"
        const val WITH_TITLE = "with_title"
    }

    private var isLoaded: Boolean = false;
    private lateinit var mUrl: String;
    private lateinit var withTitle: String;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var bundle = getArguments();
        mUrl = bundle?.getString(WEB_URL).toString();
        withTitle = bundle?.getString(WITH_TITLE).toString();
    }

    override fun addJsBridge() {
        val jsBridge = mWebView?.let {
            XDJSBridge(
                this,
                it
            )
        }
        mWebView?.addJavascriptInterface(jsBridge, XDJSBridge.JS_OBJECT_NAME)
    }

    override fun onResume() {
        super.onResume()
        if (!isLoaded) {
            isLoaded = true
            tryLoadUrl()
        }
    }

    private fun tryLoadUrl() {
        mWebView?.loadUrl(getUrl())
    }


    private fun getUrl(): String {
        return "https://www.baidu.com/";
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            if (mWebView != null) {
                mWebView?.onResume()
                mWebView?.resumeTimers()
            }
        } else {
            if (mWebView != null) {
                mWebView?.onPause()
                mWebView?.pauseTimers()
            }
        }
    }

    override fun onEventMainThread(event: EventBusParams?) {
        super.onEventMainThread(event)
        when (event?.key) {

        }
    }


    /**
     * WebView加载进度
     *
     * @param progress
     */
    override fun onUpdateProgress(progress: Int) {
        mProgressBar?.progress = progress
    }

    /**
     * WebView开始加载进度
     */
    override fun showLoadingView() {
        mProgressBar?.visibility = View.VISIBLE
        mProgressBar?.progress = 10
    }

    /**
     * WebView关闭加载进度
     */
    override fun hideLoadingView() {
        mProgressBar?.visibility = View.GONE
    }


    override fun onReceivedTitle(title: String) {
    }

    override fun onReloadUrlCallback(url: String) {
    }

    override fun onLoadPageFinished(url: String) {
    }

    override fun onLoadPageError() {
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage) {
    }

    /**
     * 是否可以返回上一页
     *
     * @return
     */
    fun webCanBack(): Boolean {
        if (mWebView != null) {
            val canGoBack = mWebView?.canGoBack()
            if (canGoBack != null && canGoBack) {
                mWebView?.goBack()
            }
            return canGoBack ?: false
        }
        return false
    }
}