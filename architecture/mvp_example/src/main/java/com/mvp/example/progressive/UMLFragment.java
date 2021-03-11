package com.mvp.example.progressive;

import com.mvp.example.last.Contract;

public class UMLFragment implements Contract.View {

    private Contract.Presenter presenter;

    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }


    private void click() {
        presenter.loadData();
    }

    @Override
    public void updateView() {
    }

    @Override
    public boolean isActive() {
        return true;
    }
}
