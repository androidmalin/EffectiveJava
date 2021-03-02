package com.example.principle.composition_aggregate_reuse_principle;


public class MyOracleConnection extends DBConnection {
    public String getConnection() {
        return "获取Oracle数据连接";
    }
}
