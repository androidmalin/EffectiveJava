package com.example.interfaceabs;

/**
 * Java接口中可以定义静态方法、default方法，枚举类型，接口中还可以定义接口（嵌套）。
 */
public interface ILog {
    enum Type {
        LOW,
        MEDIUM,
        HIGH
    }

    interface InILog {
        void initInLog();
    }

    default void init() {
        Type t = Type.HIGH;
        System.out.println(t.ordinal());
    }

    static void OS() {
        System.out.println(System.getProperty("os.name", "linux"));
    }

    void log(String string);
}

class ConsoleLog implements ILog {
    @Override
    public void log(String string) {
        System.out.println("ConsoleLog..." + string);
    }

    public static void main(String[] args) {
        ILog log = new ConsoleLog();
        log.init();
        log.log("xx");
    }
}