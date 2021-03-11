package com.mvp.example.last;

/**
 * 数据操作回调
 *
 * @param <T>
 */
public interface DataCallback<T> {

    /**
     * 通知成功
     *
     * @param data
     */
    void onSuccess(T data);

    /**
     * 通知失败
     */
    void onError();
}