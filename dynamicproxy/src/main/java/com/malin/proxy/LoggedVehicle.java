package com.malin.proxy;

/**
 * Class LoggedVehicle.
 * 我们将编写一个LoggedVehicle类，该类实现IVehicle接口，记录每个请求的操作，
 * 然后将实际操作委托给包含的IVehicle对象
 * <p>
 * 装饰器模式的实质是通过组合进行委派！
 * <p>
 * 尽管LoggedVehicle装饰器类为实现IVehicle接口的任何类提供了日志记录功能，但是此方法有两个缺点：
 * 1.必须在LoggedVehicle类中实现IVehicle接口的所有方法很繁琐
 * 2.日志记录是一种通用的功能，我们可能希望将其添加到其他接口中，在这种情况下，我们必须编写另一个包装器类
 * <p>
 * 通过使用动态代理可以克服这两个缺点.
 * <p>
 * 动态代理将自动实现我们指定的接口的所有方法，从而使我们摆脱了自己进行此实现的繁琐工作
 * 我们的invocation handler中的反射方法调用支持所需的通用的委托
 */
public class LoggedVehicle implements IVehicle {
    private final IVehicle iVehicle;

    public LoggedVehicle(IVehicle iVehicle) {
        this.iVehicle = iVehicle;
    }

    @Override
    public void start() {
        System.out.println("Log Entry: Vehicle " + iVehicle.getName() + " started");
        iVehicle.start();
    }

    @Override
    public void stop() {

    }

    @Override
    public void forward() {

    }

    @Override
    public void reverse() {

    }

    @Override
    public String getName() {
        return null;
    }
}