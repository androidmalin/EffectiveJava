package com.example.observer.demo.jdk;


public class Client {
    public static void main(String[] args) {
        GPer gper = GPer.getInstance();
        Teacher jake = new Teacher("jake");
        Teacher tom = new Teacher("tom");

        gper.addObserver(jake);
        gper.addObserver(tom);

        //用户行为
        Question question = new Question();
        question.setUserName("张三");
        question.setContent("观察者模式适用于哪些场景？");

        gper.publishQuestion(question);
    }
}
