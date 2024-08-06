package com.example.demo.interfaces;

public class Wiring {

    public static void main(String[] args) {
        ISwitchboardListener isbl = new GeAppliances();
                //new HavellsAppliances();  //wiring

        //tanmay clicking
        isbl.switchOne();
        isbl.switchTwo();
        isbl.switchThree();
        isbl.switchFour();
    }
}
