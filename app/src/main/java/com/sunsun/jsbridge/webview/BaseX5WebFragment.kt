package com.sunsun.jsbridge.webview;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.sunsun.jsbridge.R
import com.sunsun.jsbridge.webview.presenter.IX5WebViewPresenter
import com.sunsun.jsbridge.webview.presenter.impl.X5WebViewPresenter
import com.tencent.smtt.sdk.WebView

abstract class BaseX5WebFragment : BaseFragment(), IX5WebViewPresenter.View {

    private lateinit var presenter: IX5WebViewPresenter
    protected var mWebView: WebView? = null
    protected var mProgressBar: ProgressBar? = null
    private var mRootLayout: ViewGroup? = null

    /**
     * 业务数据
     */
    protected var mBusinessData: String? = null

    override fun setupLayoutId(): Int = R.layout.base_x5_web_view_fragment_layout

    override fun getX5Context(): Context?{
     return  this.context;
    }

    override fun initView(view: View?) {
        mWebView = view?.findViewById(R.id.web_view)
        mProgressBar = view?.findViewById(R.id.web_load_progress)
        mRootLayout = view?.findViewById(R.id.root_web_view_layout)

        initPresenter()

        initWebView()
    }


    override fun initBundle(savedInstanceState: Bundle?) {
        val bundle = arguments
        if (bundle != null && bundle.containsKey(WebViewConstant.WEB_BUSINESS_DATA)) {
            try {
                mBusinessData = bundle.getString(WebViewConstant.WEB_BUSINESS_DATA)
            } catch (ex: Exception) {
            }
        }
    }

    private fun initPresenter() {
        presenter = X5WebViewPresenter(this)
    }

    private fun initWebView() {
        mWebView?.let {
            WebViewHelper.initX5WebView(it)
            setWebViewClient()
            setWebChromeClient()
            addJsBridge()
        }

    }

    private fun setWebViewClient() {
        mWebView?.webViewClient = presenter.tryGetWebClient()
    }

    private fun setWebChromeClient() {
        mWebView?.webChromeClient = presenter.tryGetWebChromeClient()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        data?.let { presenter.tryHandleOnActivityResult(requestCode, resultCode, it) }
    }

    abstract fun addJsBridge()

    override fun showLoadingView() {
//        mProgressBar?.visibility=View.VISIBLE
//        mProgressBar?.progress = 10
    }

    override fun hideLoadingView() {
//        mProgressBar?.visibility=View.GONE
    }

    override fun onUpdateProgress(progress: Int) {
//        mProgressBar?.progress = progress
    }

    override fun onDetach() {
        releaseWebView()
        super.onDetach()
    }

    private fun releaseWebView() {
        if (mRootLayout != null && mWebView != null) {
            mWebView?.stopLoading()
            mRootLayout?.removeView(mWebView)
            mWebView?.removeAllViews()
            mWebView?.removeAllViewsInLayout()
            mWebView?.webChromeClient = null
            mWebView?.destroy()
            mWebView = null
        }
    }
}