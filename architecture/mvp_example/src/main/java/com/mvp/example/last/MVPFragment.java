package com.mvp.example.last;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.malin.video.R;

public class MVPFragment extends Fragment implements Contract.View {

    private TextView mTvContent;
    private Button mBtnFresh;
    private Contract.Presenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.mvp_activity_fragment_layout, container, false);
        initView(rootView);
        initListener();
        return rootView;
    }

    private void initView(View rootView) {
        mTvContent = rootView.findViewById(R.id.tv);
        mBtnFresh = rootView.findViewById(R.id.btn);
    }

    private void initListener() {
        mBtnFresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.loadData();
            }
        });
    }

    @Override
    public void updateView() {
        mTvContent.setText(String.valueOf(System.currentTimeMillis()));
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    /**
     * Presenter注入,目的是让View中持有一个Presenter的引用来实现通信.
     *
     * @param presenter presenter
     */
    @Override
    public void setPresenter(Contract.Presenter presenter) {
        this.presenter = presenter;
    }


    /**
     * Fragment生命周期onResume
     * <p>
     * Presenter生命周期开始
     */
    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    /**
     * Fragment生命周期onDestroy
     * <p>
     * Presenter生命周期结束
     */
    @Override
    public void onDestroy() {
        presenter.destroy();
        super.onDestroy();
    }
}
