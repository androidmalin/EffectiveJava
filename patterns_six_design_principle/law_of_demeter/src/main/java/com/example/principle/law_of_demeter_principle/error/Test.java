package com.example.principle.law_of_demeter_principle.error;

public class Test {

    public static void main(String[] args) {
        testSquare();
    }

    private static void testSquare() {
        Square rectangle = new Square();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        resize(rectangle);
    }

    private static void testRectangle() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20);
        rectangle.setHeight(10);
        resize(rectangle);
    }


    private static void resize(Rectangle rectangle) {
        while (rectangle.getWidth() >= rectangle.getHeight()) {
            rectangle.setHeight(rectangle.getHeight() + 1);
            System.out.println("w:" + rectangle.getWidth() + ",h:" + rectangle.getHeight());
        }
    }
}
