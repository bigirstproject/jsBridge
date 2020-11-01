package com.sunsun.jsbridge.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.widget.Toast;

import com.tencent.smtt.sdk.WebView;


import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WebViewHelper {

    // h5callBack的map，key为fuc
    public static Map<String, String> callBackMap = new HashMap<>();

    public static void openSystemWebView(Context context, String url) {
        if (context == null || TextUtils.isEmpty(url)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(url);
        intent.setData(content_url);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 初始化X5 webview
     *
     * @param webView
     */
    public static void initX5WebView(final WebView webView) {
        com.tencent.smtt.sdk.WebSettings webSettings = webView.getSettings();
        String ua = webSettings.getUserAgentString();
        com.tencent.smtt.sdk.CookieManager.getInstance().acceptCookie();
        webView.getSettings().setUserAgentString(ua + " /1.2.0");
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.setDownloadListener(new com.tencent.smtt.sdk.DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                if (TextUtils.isEmpty(url)) {
                    Toast.makeText(webView.getContext(), "下载链接不存在",Toast.LENGTH_SHORT).show();
                    return;
                }
                openSystemWebView(webView.getContext(), url);
            }
        });


        webSettings.setJavaScriptEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webSettings.setDomStorageEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setAppCacheEnabled(false);
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);
        webSettings.setLayoutAlgorithm(com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.NORMAL);
        webSettings.setUseWideViewPort(true);
        webSettings.setLoadWithOverviewMode(true);

    }


    public static void initWebView(final android.webkit.WebView mWebView) {
        WebSettings webSettings = mWebView.getSettings();
        String ua = webSettings.getUserAgentString();
        CookieManager.getInstance().acceptCookie();
        mWebView.getSettings().setUserAgentString(ua + "/1.2.0");
        mWebView.removeJavascriptInterface("searchBoxJavaBridge_");
        mWebView.removeJavascriptInterface("accessibility");
        mWebView.removeJavascriptInterface("accessibilityTraversal");
        mWebView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {

            }
        });


        webSettings.setJavaScriptEnabled(true);
        webSettings.setSavePassword(false);
        webSettings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        webSettings.setDomStorageEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        webSettings.setAppCacheEnabled(false);
        webSettings.setAllowFileAccess(false);
        webSettings.setAllowFileAccessFromFileURLs(false);
        webSettings.setAllowUniversalAccessFromFileURLs(false);

    }

    /**
     * 处理回调h5的callBack
     * @param activity
     * @param json
     * @param key
     * @param forever 是否持续回调
     */
    public static void handCallWeb(Activity activity, WebView webView, String json, String key, boolean forever) {
        String callBack = callBackMap.get(key);
        if (TextUtils.isEmpty(callBack)) {
            return;
        }
        if (webView != null) {
            final StringBuilder sb = new StringBuilder("javascript:");
            sb.append(callBack);
            sb.append("(\'");
            sb.append(json);
            sb.append("\')");
            safeLoadUrl(activity, webView, sb.toString());
            if (!forever){
                callBackMap.remove(key);
            }

        }
    }

    public static void safeLoadUrl(Activity activity,final  WebView webView,final String url){
        try{
            webView.post(new Runnable() {
                @Override
                public void run() {
                    webView.loadUrl(url);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
            webView.post(() -> webView.loadUrl(url));
        }
    }


    public static final String JS_START_TAG = "javascript:";

    public static String tryGetJsFunction(String function) {
        return JS_START_TAG + function + "()";
    }

    public static String tryGetJsFunction(String function, String data) {
        return JS_START_TAG + function + "(\'" + data + "\')";
    }

    public static String tryGetJsFunction(String function, HashMap map) {
        JSONObject jsonObject = new JSONObject(map);
        String data = jsonObject.toString();
        return JS_START_TAG + function + "(\'" + data + "\')";
    }
}
