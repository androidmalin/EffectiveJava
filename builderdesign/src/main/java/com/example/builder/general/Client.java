package com.example.builder.general;


public class Client {
    public static void main(String[] args) {
        IBuilder builder = new ConcreteBuilder();
        System.out.println(builder.build().name);
    }

    private static class Product {
        private String name;

        @Override
        public String toString() {
            return "Product{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private interface IBuilder {
        Product build();
    }

    private static class ConcreteBuilder implements IBuilder {
        private final Product product = new Product();

        @Override
        public Product build() {
            return product;
        }
    }
}
