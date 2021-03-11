package com.mvp.example.last;

/**
 * 契约类,查看Presenter和View之间交互的情况.
 * 包含Presenter和View的接口.
 * <p>
 * 方便从整体上了解模块的功能
 * <p>
 * 这里涉及到的问题
 * 1.接口中内部接口的理解(内部接口/嵌套接口)
 * 2.接口的继承
 * 3.泛型的上限
 */
public interface Contract {

    /**
     * 在接口中的任何类都是自动地是public和static的
     * <p>
     * 因为接口不能被实例化，所以内部接口只有在静态时才有意义。
     * 因此，默认情况下，无论您是否手动添加静态，内部接口都是静态的。
     * <p>
     * 为什么要使用内部接口
     * 如下是一些强有力的理由:
     * 1.一种对那些在同一个地方使用的接口进行逻辑上分组;
     * 2.增加封装,封装思想的体现;内部接口不属于全局作用域范围;
     * 3.嵌套接口可以增强代码的易读性和可维护性;通过将相关接口集中在一个位置来提高可读性
     * 4.当接口具有通用名称时解决命名空间问题
     *
     * <p>
     * https://www.cnblogs.com/chenpi/p/5518400.html
     * https://hengbao.blog.csdn.net/article/details/53224165
     * https://www.baeldung.com/java-inner-interfaces
     * https://stackoverflow.com/questions/71625/why-would-a-static-nested-interface-be-used-in-java
     */
    public static interface View extends BaseView<Presenter> {
        void updateView();

        boolean isActive(); // 判断Fragment是否已经添加到了Activity中
    }


    interface Presenter extends BasePresenter {
        void loadData();
    }
}
