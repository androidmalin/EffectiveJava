package com.malin.proxy.test;

public class StaticProxyBuyer implements IBuy {
    private final IBuy iBuy;

    public StaticProxyBuyer(IBuy iBuy) {
        this.iBuy = iBuy;
    }

    @Override
    public void buy() {
        iBuy.buy();
    }
}
