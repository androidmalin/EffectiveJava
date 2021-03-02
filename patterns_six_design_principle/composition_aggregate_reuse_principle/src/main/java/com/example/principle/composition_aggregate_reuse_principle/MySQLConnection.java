package com.example.principle.composition_aggregate_reuse_principle;


public class MySQLConnection extends DBConnection {
    public String getConnection() {
        return "获取MySQL数据连接";
    }
}
