package com.sunsun.jsbridge.webview;

public interface IWebViewCallback {

    void onShouldOverrideUrlLoading(String url);

    void onPageStarted();

    void onPageFinished(String url);

    void onPageError();
}
