package  com.sunsun.jsbridge.webview.presenter.impl;

import android.content.Intent
import android.net.Uri
import android.os.Build
import com.sunsun.jsbridge.webview.BaseX5WebChromeClient
import com.sunsun.jsbridge.webview.BaseX5WebViewClient
import com.sunsun.jsbridge.webview.IWebViewCallback
import com.sunsun.jsbridge.webview.IX5WebChromeCallBack
import com.sunsun.jsbridge.webview.presenter.IX5WebViewPresenter
import com.tencent.smtt.export.external.interfaces.ConsoleMessage
import com.tencent.smtt.sdk.ValueCallback
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebViewClient


class X5WebViewPresenter(val mView: IX5WebViewPresenter.View) : IX5WebViewPresenter,
    IWebViewCallback, IX5WebChromeCallBack {
    companion object {
        const val REQUEST_CAMERA = 101  //请求拍照
        const val REQUEST_GALLERY = 102 //请求相册
        const val REQUEST_VIDEO = 103 //请求录制
    }

    private var mWebClient = BaseX5WebViewClient(this)
    private var mChromeClient: BaseX5WebChromeClient? = null
    private var mIsStart = false
    private var mUploadMsg: ValueCallback<Uri>? = null
    private var mUploadMsgV5: ValueCallback<Array<Uri>>? = null
    private var mImageUri: Uri? = null

    override fun tryGetWebClient(): WebViewClient {
        return mWebClient
    }

    override fun tryGetWebChromeClient(): BaseX5WebChromeClient {
        if (mChromeClient == null) {
            mChromeClient = BaseX5WebChromeClient(this)
        }
        return mChromeClient!!
    }

    override fun tryHandleOnActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

    }

    override fun onShouldOverrideUrlLoading(url: String) {
        mView.onReloadUrlCallback(url)
    }

    override fun onPageStarted() {
        if (mIsStart) {
            return
        }
        mIsStart = true
        mView.showLoadingView()
    }

    override fun onPageFinished(url: String) {
        mIsStart = false
        mView.onLoadPageFinished(url)
        mView.hideLoadingView()
    }

    override fun onProgressChanged(progress: Int) {
        if (progress >= 100) {
            mView.hideLoadingView()
            return
        }
        if (progress <= 10) {
            return
        }
        mView.onUpdateProgress(progress)
    }

    override fun onReceivedTitle(title: String) {
        mView.onReceivedTitle(title)
    }

    override fun onPageError() {
        mView.onLoadPageError()
    }

    override fun onOpenFileChooserCallBack(uploadMsg: ValueCallback<Uri>, acceptType: String) {
        mUploadMsg = uploadMsg
        handleOnWebChooseFile(acceptType)
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage) {
        mView?.onConsoleMessage(consoleMessage)
    }

    override fun onShowFileChooserCallBack(
        filePathCallback: ValueCallback<Array<Uri>>,
        fileChooserParams: WebChromeClient.FileChooserParams
    ) {
        mUploadMsgV5 = filePathCallback
        var acceptTypes: Array<String>? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            acceptTypes = fileChooserParams.acceptTypes
        }
        var acceptType = ""
        if (acceptTypes != null && acceptTypes.isNotEmpty()) {
            acceptType = acceptTypes[0]
        }
        handleOnWebChooseFile(acceptType)
    }


    /**
     * 处理文件选择
     */
    private fun handleOnWebChooseFile(type: String) {
        if (mView.getX5Context() == null) {
            return
        }
    }

}