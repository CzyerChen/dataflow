package com.dataflow.core.constant;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Desciption  重试枚举类
 *
 * @author Claire.Chen
 * @create_time 2019 -04 - 10 14:46
 */
public enum RetryModeEnum {
    ALWAYS,//一直重试
    TIMEOUT_DISCARD,//超过重试次数后丢弃数据
    TIMEOUT_ERROR,//超过重试次数后抛异常，终止任务
    NO_TIL_ERROR;//不重试，直接抛异常,终止Task

    public static List<RetryModeEnum> getAllModes() {
        return Lists.newArrayList(ALWAYS, TIMEOUT_DISCARD, TIMEOUT_ERROR, NO_TIL_ERROR);
    }
}
