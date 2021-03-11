package com.mvp.example.last;

public interface BaseView<T extends BasePresenter> {

    //1.View中需要持有一个Presenter的引用来实现通信.
    //2.持有一个Presenter的引用==>可以通过依赖注入的方式实现.
    //3.三种依赖注入:
    //              a.构造函数;
    //              b.set函数;
    //              c.接口注入;
    // 这里BaseView2是一个接口需要选择一种合适的方式来实现注入,要从宏观的角度思考,View最后的实现者是Activity或者Fragment;
    // 面向接口编程,这里可以考虑使用接口注入.
    //4.为了通用,考虑到不确定Presenter的具体类型,于是使用泛型
    //5.在接口中使用泛型的方式.
    //6.注意在接口中使用泛型时,泛型的声明.
    //7.为了对泛型参数T做一个上限的限制.使用到BasePresenter.明确T必须是BasePresenter的实现类
    //增加T的上限
    void setPresenter(T t);
}
