package com.sunsun.jsbridge.webview;

import android.graphics.Bitmap
import android.text.TextUtils
import com.tencent.smtt.export.external.interfaces.*
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import java.util.*

class BaseX5WebViewClient(callback: IWebViewCallback) : WebViewClient() {
    private val mLimitUrlList = ArrayList<String>()
    private val mCallback: IWebViewCallback = callback

    init {
        setupNewLimitUrl(WebViewConstant.MAIL)
        setupNewLimitUrl(WebViewConstant.TEL)
        setupNewLimitUrl(WebViewConstant.WEIXIN)
        setupNewLimitUrl(WebViewConstant.ALIPAYS)
    }

    /**
     * 添加限制链接
     *
     * @param url
     */
    private fun setupNewLimitUrl(url: String) {
        if (TextUtils.isEmpty(url)) {
            return
        }
        for (limitUrl in mLimitUrlList) {
            if (limitUrl == url) {
                return
            }
        }
        mLimitUrlList.add(url)
    }

    /**
     * 检测是否被限制
     *
     * @param url url
     * @return true yes false no
     */
    private fun doCheckLimitUrl(url: String): Boolean {
        if (TextUtils.isEmpty(url)) {
            return false
        }
        if (mLimitUrlList.size == 0) {
            return false
        }
        for (limitUrl in mLimitUrlList) {
            if (url.startsWith(limitUrl) || url == limitUrl) {
                return true
            }
        }
        return false
    }

    /**
     * 访问HTTPS 接受证书
     *
     * @param view
     * @param handler
     * @param error
     */
    override fun onReceivedSslError(view: WebView?, handler: SslErrorHandler?, error: SslError?) {
        handler?.proceed()
        try {
            //TODO 补充埋点
            //SensorsManager.getInstance().track(KEY_H5_ERROR_EVENT, H5ErrorEvent("x5", "SSLError", error?.primaryError.toString()))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        mCallback.onShouldOverrideUrlLoading(url)
        return doCheckLimitUrl(url ?: "")
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        // 加载结束监听
        val title = if (view?.title == null) "" else view.title
        //TODO 补充埋点
        //SensorsManager.getInstance().trackTimerEnd(KEY_H5_PAGE_LOAD_TIME, EventPageBean(title, null, null, null, url))
        mCallback.onPageFinished(url)
        super.onPageFinished(view, url)
    }


    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        mCallback.onPageStarted()
        // 加载开始监听
        //TODO 补充埋点
        //SensorsManager.getInstance().trackTimerStart(KEY_H5_PAGE_LOAD_TIME)
        mCallback.onPageStarted()
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        super.onReceivedError(view, request, error)
        try {
            //TODO 补充埋点
            //SensorsManager.getInstance().track(KEY_H5_ERROR_EVENT, H5ErrorEvent(request?.url.toString(), error?.description.toString(), error?.errorCode.toString()))
        } catch (e: Exception) {
            e.printStackTrace()
        }

        //只有是主请求才处理PageError 避免图片资源丢失导致直接展示失败页面
        if (request?.isForMainFrame == true)
            mCallback.onPageError()
    }

    override fun onReceivedHttpError(
        view: WebView?,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        super.onReceivedHttpError(view, request, errorResponse)
        try {
            //TODO 补充埋点
            //SensorsManager.getInstance().track(KEY_H5_ERROR_EVENT, H5ErrorEvent(request?.url.toString(), errorResponse
//                    ?.reasonPhrase, errorResponse?.statusCode.toString()))
        } catch (e: Exception) {
            e.printStackTrace()
        }
        //只有是主请求才处理PageError 避免图片资源丢失导致直接展示失败页面
        if (request?.isForMainFrame == true)
            mCallback.onPageError()
    }


}