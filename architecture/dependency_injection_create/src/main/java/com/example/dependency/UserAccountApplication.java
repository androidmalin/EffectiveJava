package com.example.dependency;

import com.example.dependency.application.CustomDemoApplication;
import com.example.dependency.di.framework.annotations.CustomApplication;

/**
 * https://dzone.com/articles/dependency-injection-implementation-in-core-java-1#
 * <p>
 * Injector class plays a major role in the DI framework. Because it is responsible to create instances of all clients and autowire instances for each service in client classes.
 * <p>
 * Steps:
 * <p>
 * 1. Scan all the clients under the root package and all sub packages
 * 扫描根目录和所有子目录下的所有client类
 * <p>
 * 2. Create an instance of client class.
 * 创建client类的实例
 * <p>
 * 3. Scan all the services using in the client class (member variables, constructor parameters, method parameters)
 * 扫描client类中使用的所有services（成员变量、构造函数参数、方法参数）
 * <p>
 * 4. Scan for all services declared inside the service itself (nested dependencies), recursively
 * 以递归方式扫描在service内声明的所有service（嵌套依赖项）
 * <p>
 * 5. Create instance for each service returned by step 3 and step 4
 * 为步骤3和步骤4返回的每个service创建实例
 * <p>
 * 6. Autowire: Inject (ie. initialize) each service with instance created at step 5
 * Autowire:使用步骤5中创建的实例注入（即初始化）每个service
 * <p>
 * 7. Create Map all the client classes  Map<Class, Object>
 * 创建映射所有client类Map<Class, Object>
 * <p>
 * 8. Expose API to get the getBean(Class clazz)/getService(Class clazz).
 * 公开API以获取getBean（Class clazz）/getService（Class clazz）
 * <p>
 * 9. Validate if there are multiple implementations of the interface or there is no implementation
 * 验证接口是否有多个实现类或没有实现类
 * <p>
 * 10. Handle Qualifier for services or autowire by type in case of multiple implementations.
 * 在有多个实现类的情况下，按类型或autowire的限定符处理service
 */
@CustomApplication
public class UserAccountApplication {

    public static void main(String[] args) {
        CustomDemoApplication.run(UserAccountApplication.class, args);
    }
}
