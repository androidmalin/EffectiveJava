package com.atguigu.mediator.smarthouse;

public class TV extends Colleague {

    public TV(Mediator mediator, String name) {
        super(mediator, name);
        // TODO Auto-generated constructor stub
        mediator.Register(name, this);
    }

    @Override
    public void SendMessage(int stateChange) {

        this.GetMediator().GetMessage(stateChange, this.name);
    }

    public void StartTv() {

        System.out.println("It's time to StartTv!");
    }

    public void StopTv() {

        System.out.println("StopTv!");
    }
}
