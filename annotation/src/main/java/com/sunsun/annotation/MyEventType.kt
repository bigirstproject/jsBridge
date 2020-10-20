package com.sunsun.annotation


/**
 * {事件类型注解类}
 *
 * @param type 主事件类型
 */
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class MyEventType(val type: String)
