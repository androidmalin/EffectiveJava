package com.mvp.example.last;

import java.util.List;

public class CommonPresenter implements Contract.Presenter {

    /**
     * View
     */
    private final Contract.View view;
    private final LocalDataSource localDataSource;

    /**
     * 注入View
     * Presenter中需要持有一个View的引用,来实现通信.
     *
     * @param view Contract.View
     */
    public CommonPresenter(Contract.View view) {
        this.view = view;
        this.localDataSource = LocalDataSource.getInstance();
    }


    @Override
    public void loadData() {
        localDataSource.getAll(new DataCallback<List<Bean>>() {
            @Override
            public void onSuccess(List<Bean> data) {
                view.updateView();
            }

            @Override
            public void onError() {
                view.updateView();
            }
        });
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
