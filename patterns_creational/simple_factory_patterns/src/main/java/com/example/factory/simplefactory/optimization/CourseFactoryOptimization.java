package com.example.factory.simplefactory.optimization;

public class CourseFactoryOptimization {

    /**
     * 客户端调用虽然简单了，但如果业务继续扩展，要增加前端课程，
     * 则工厂中的create()方法就要随着产品链的丰富每次都要修改代码逻辑，
     * 这不符合开闭原则。
     * 因此，我们可以采用反射技术继续对简单工厂模式进行优化，代码如下。
     */
    public static ICourse create(Class<? extends ICourse> clazz) {
        ICourse iCourse = null;
        try {
            iCourse = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return iCourse;
    }
}
