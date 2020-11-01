package com.sunsun.jsbridge.interpreter;

import java.io.Serializable

/**
 * Description: ${todo}
 * Created by 林振华，2020/2/26
 */
open class BaseEventBean<T>: Serializable {
    var code: Int = -1
    var message: String = ""
    var data: T? = null

}

val CODE_H5_SUCCESS = 0  //成功
val CODE_H5_FAILED = -1 //失敗
val CODE_H5_FUNCNOTFOUND = 40001 //協議未找到
val CODE_H5_LIMIT = 50001 //用戶未授權
val CODE_H5_CANCEL = 50002 //用戶取消