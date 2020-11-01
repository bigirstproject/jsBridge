package  com.sunsun.jsbridge.webview.presenter;

import android.content.Context
import android.content.Intent
import com.sunsun.jsbridge.webview.BaseX5WebChromeClient
import com.tencent.smtt.export.external.interfaces.ConsoleMessage
import com.tencent.smtt.sdk.WebViewClient

/**
 * ${X5内核的基础web页P层抽象}
 * @author lixiuxian
 * @date 2019-08-26
 */
interface IX5WebViewPresenter {
    interface View {
        fun getX5Context(): Context?

        fun showLoadingView()

        fun hideLoadingView()
        fun onUpdateProgress(progress: Int)
        fun onReceivedTitle(title: String)

        fun onReloadUrlCallback(url: String)

        fun onLoadPageFinished(url: String)

        fun onLoadPageError()

        fun onConsoleMessage(consoleMessage: ConsoleMessage)
    }

    fun tryGetWebClient(): WebViewClient

    fun tryGetWebChromeClient(): BaseX5WebChromeClient

    fun tryHandleOnActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
}