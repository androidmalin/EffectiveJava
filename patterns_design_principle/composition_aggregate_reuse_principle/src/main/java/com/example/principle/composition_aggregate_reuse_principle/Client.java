package com.example.principle.composition_aggregate_reuse_principle;


/**
 * 组合复用原则
 * 组合复用原则也叫合成/聚合复用原则（CARP），
 * 就是在一个新的对象里面使用一些已有的对象，使之成为新对象的一部分；
 * <p>
 * 新的对象通过向这些对象的委派达到复用已有功能的目的。
 * 这个原则的简短表述就是：要尽量使用组合，尽量不要使用继承。
 */
public class Client {
    public static void main(String[] args) {
        testOracle();
        testMySQL();
    }

    private static void testOracle() {
        ProductDao productDao = new ProductDao();
        productDao.setConnection(new MyOracleConnection());
        productDao.addProduct();
    }

    private static void testMySQL() {
        ProductDao productDao = new ProductDao();
        productDao.setConnection(new MySQLConnection());
        productDao.addProduct();
    }


}
