package com.example.observer.demo.jdk;

import java.util.Observable;

public class GPer extends Observable {

    private final String name = "GPer生态圈";

    private static final GPer instance = new GPer();

    private GPer() {
    }

    public static GPer getInstance() {
        return instance;
    }

    public String getName() {
        return name;
    }

    public void publishQuestion(Question question) {
        System.out.println(question.getUserName() + "在" + this.name + "上提交了一个问题。");
        setChanged();
        notifyObservers(question);
    }
}
