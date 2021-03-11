package com.mvp.example.last;

import android.support.annotation.NonNull;

import java.util.List;

public class LocalDataSource implements DataSource<Bean> {

    private LocalDataSource() {
    }

    private static class Holder {
        private static final LocalDataSource INSTANCE = new LocalDataSource();
    }

    public static LocalDataSource getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void getAll(@NonNull DataCallback<List<Bean>> callback) {

    }

    @Override
    public void get(@NonNull String id, @NonNull DataCallback<Bean> callback) {

    }

    @Override
    public void update(@NonNull Bean bean) {

    }

    @Override
    public void clear() {

    }

    @Override
    public void delete(@NonNull String id) {

    }
}
