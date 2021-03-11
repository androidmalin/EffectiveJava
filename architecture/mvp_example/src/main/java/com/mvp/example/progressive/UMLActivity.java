package com.mvp.example.progressive;

import com.mvp.example.last.CommonPresenter;

public class UMLActivity {

    private void onCreate() {
        UMLFragment fragment = new UMLFragment();
        fragment.setPresenter(new CommonPresenter(fragment));
    }
}
