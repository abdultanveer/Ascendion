package com.example.demo.interfaces;
public class GeAppliances implements ISwitchboardListener{

    @Override
    public void switchOne() {
        System.out.println("GE fan is on");
    }

    @Override
    public void switchTwo() {
        System.out.println("GE bulb is on");

    }

    @Override
    public void switchThree() {
        System.out.println("GE heater is on");
    }

    @Override
    public void switchFour() {
        System.out.println("GE tv is on");
    }
}
