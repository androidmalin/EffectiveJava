package com.malin.proxy;

/**
 * Class VehicleProxy.
 */
public class VehicleProxy implements IVehicle {

    private final IVehicle iVehicle;

    public VehicleProxy(IVehicle iVehicle) {
        this.iVehicle = iVehicle;
    }

    public void start() {
        System.out.println("VehicleProxy: Begin of start()");
        iVehicle.start();
        System.out.println("VehicleProxy: End of start()");
    }

    @Override
    public void stop() {
        System.out.println("VehicleProxy: Begin of stop()");
        iVehicle.stop();
        System.out.println("VehicleProxy: End of stop()");
    }

    @Override
    public void forward() {
        System.out.println("VehicleProxy: Begin of forward()");
        iVehicle.forward();
        System.out.println("VehicleProxy: End of forward()");
    }

    @Override
    public void reverse() {
        System.out.println("VehicleProxy: Begin of reverse()");
        iVehicle.reverse();
        System.out.println("VehicleProxy: End of reverse()");
    }

    @Override
    public String getName() {
        return iVehicle.getName();
    }
}