package com.sunsun.jsbridge.webview;


public class WebViewConstant {


    /**
     * H5 电话 & Email拦截
     **/
    public final static String MAIL = "mailto:";
    public final static String TEL = "tel:";
    public final static String WEIXIN = "weixin://";
    public final static String ALIPAYS = "alipays://";
    public final static String HELP_TITLE = "助手";
    public final static String IPCRS_URL = "https://ipcrs.pbccrc.org.cn/";

    public final static String WEB_PARAM = "web_param"; //webview参数

    public final static String WEB_BUSINESS_DATA = "web_business_data";//业务数据(上一个页面带下来的)

    public final static String PAYTYPE_JD = "1"; //及贷还款
    public final static String PAYTYPE_SY = "2"; //闪银还款

    public final static String SHOW_SHARE_VISIBLE = "show_share_visible";

    public final static String PAGE_REFRESH = "page_refresh";

    /**
     * 提交微信授权账户信息 事件
     */
    @Deprecated
    public final static String POST_THIRD_PARTY_INFO = "postThirdPartyInfo";

    /**
     * 微信订阅 事件
     */
    public final static String WECHAT_SUBSCRIBE_ACTION_INFO = "wechatSubscribeActionInfo";

}
