package com.example.demo.interfaces;

public class HavellsAppliances implements ISwitchboardListener {


    @Override
    public void switchOne() {
        System.out.println("havells fan is on");
    }

    @Override
    public void switchTwo() {
        System.out.println("havells bulb is on");

    }

    @Override
    public void switchThree() {
        System.out.println("havells heater is on");
    }

    @Override
    public void switchFour() {
        System.out.println("havells tv is on");
    }
}
