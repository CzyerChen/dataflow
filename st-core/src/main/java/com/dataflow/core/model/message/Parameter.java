package com.dataflow.core.model.message;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;
import java.util.List;

/**
 * 参数顶层抽象类
 */
public abstract class Parameter implements Serializable {

    public String toJsonString() {
        return JSONObject.toJSONString(this, SerializerFeature.WriteClassName);
    }

    public static String listToJsonString(List list) {
        return JSONObject.toJSONString(list, SerializerFeature.WriteClassName);
    }
}
