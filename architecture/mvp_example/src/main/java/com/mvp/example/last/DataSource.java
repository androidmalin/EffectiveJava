package com.mvp.example.last;

import android.support.annotation.NonNull;

import java.util.List;

public interface DataSource<T> {

    /**
     * 获得所有数据T
     *
     * @param callback DataCallback
     */
    void getAll(@NonNull DataCallback<List<T>> callback);

    /**
     * 获取某个数据T
     *
     * @param id       id
     * @param callback DataCallback
     */
    void get(@NonNull String id, @NonNull DataCallback<T> callback);

    /**
     * 更新某个数据T
     *
     * @param t t
     */
    void update(@NonNull T t);

    /**
     * 清空所有数据T
     */
    void clear();

    /**
     * 删除某个数据T
     *
     * @param id id
     */
    void delete(@NonNull String id);
}
