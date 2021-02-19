package com.example.decorator.pattern.log;

import com.alibaba.fastjson.JSONObject;

public class JsonLoggerDecorator extends AbsLogDecorator implements ILogger {

    public JsonLoggerDecorator(ILogger iLogger) {
        super(iLogger);
    }

    @Override
    public void info(String msg) {
        JSONObject jsonObject = getJSONObject();
        jsonObject.put("msg", msg);
        iLogger.info(jsonObject.toJSONString());
    }

    @Override
    public void error(String msg) {
        JSONObject jsonObject = getJSONObject();
        jsonObject.put("msg", msg);
        iLogger.error(jsonObject.toJSONString());
    }

    @Override
    public void warn(String msg) {
        JSONObject jsonObject = getJSONObject();
        jsonObject.put("msg", msg);
        iLogger.warn(jsonObject.toJSONString());
    }


    private JSONObject getJSONObject() {
        return new JSONObject();
    }
}
