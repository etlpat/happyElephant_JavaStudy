package com._01_designPatternBasic.test04_interfaceIsolation;

public class Door2 implements GuardAgainstTheft, Fireproof {
    @Override
    public void fireproof() {
        System.out.print("防火");
    }

    @Override
    public void guard() {
        System.out.print("防盗");
    }


    public void check() {
        System.out.print("功能：");
        fireproof();
        guard();
        System.out.println();
    }

}

