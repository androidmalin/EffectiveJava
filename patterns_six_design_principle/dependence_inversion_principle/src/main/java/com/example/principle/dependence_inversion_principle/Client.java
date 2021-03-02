package com.example.principle;


import com.example.principle.dependence_inversion_principle.Tom;

/**
 * 依赖倒置原则
 * 依赖倒置原则（Dependence Inversion Principle，DIP）
 * 指设计代码结构时，高层模块不应该依赖底层模块，二者都应该依赖其抽象。
 * <p>
 * 抽象不应该依赖细节，细节应该依赖抽象。
 * <p>
 * 通过依赖倒置，可以降低类与类之间的耦合性，提高系统的稳定性，
 * 提高代码的可读性和可维护性，并降低修改程序带来的风险.
 */
public class Client {

    public static void main(String[] args) {
        Tom tom = new Tom();
        tom.setICourse(new JavaCourse());
        tom.setICourse(new PythonCourse());
        tom.study();
    }
}
