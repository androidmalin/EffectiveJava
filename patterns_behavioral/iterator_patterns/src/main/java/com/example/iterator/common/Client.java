package com.example.iterator.common;

public class Client {

    public static void main(String[] args) {

        //来一个容器对象
        IAggregate<String> aggregate = new ConcreteAggregate<>();

        //添加元素
        aggregate.add("one");
        aggregate.add("two");
        aggregate.add("three");

        //获取容器对象迭代器
        Iterator<String> iterator = aggregate.iterator();

        //遍历
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}