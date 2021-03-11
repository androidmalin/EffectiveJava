package com.example.factory.factorymethod;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.impl.Log4jLoggerFactory;

/**
 * Logback
 * implementation 'org.slf4j:slf4j-log4j12:1.7.2'
 */
public class SdkClient {

    public static void main(String[] args) {
        ILoggerFactory iLoggerFactory = new Log4jLoggerFactory();
        Logger logger = iLoggerFactory.getLogger("");
        logger.info("xxx");
    }
}
