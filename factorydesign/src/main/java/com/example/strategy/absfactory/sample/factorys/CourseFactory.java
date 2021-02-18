package com.example.strategy.absfactory.sample.factorys;


import com.example.strategy.absfactory.sample.products.INote;
import com.example.strategy.absfactory.sample.products.IVideo;

/**
 * 抽象工厂是用户的主入口
 * 在Spring中应用得最为广泛的一种设计模式
 * 易于扩展
 */
public abstract class CourseFactory {

    public abstract INote createNote();

    public abstract IVideo createVideo();

}
