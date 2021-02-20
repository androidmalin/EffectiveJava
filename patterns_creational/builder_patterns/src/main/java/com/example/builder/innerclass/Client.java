package com.example.builder.innerclass;


/**
 * 使用静态内部类实现建造者模式
 * <p>
 * 事实上，在平常的编码中，我们通常都会忽略对象的复杂性，优先考虑使用
 * 工厂模式创建对象，而不是建造者模式。因为工厂模式和建造者模式的作用都是
 * 创建一个产品对象，而工厂模式的结构更加简洁直接（没有Builder和
 * Director)，因此更常使用。
 * <p>
 * <p>
 * 一般情况下，我们更习惯使用静态内部类的方式实现建造者模式，
 * 即一个产品类内部自动带有一个具体建造者，由它负责该产品的组装创建，
 * 不再需要Builder和Director，
 * 这样，产品表示与创建之间的联系更加紧密，结构更加紧凑，同时使得建造者模式的形式更加简洁。
 * 如果采用静态内部类形式实现建造者模式，则前面的案例可以改写如下。
 */
public class Client {
    public static void main(String[] args) {
        Course course = new Course.Builder()
                .addName("设计模式")
                .addPPT("PPT课件")
                .addVideo("录播视频")
                .build();
        System.out.println(course);
    }
}
