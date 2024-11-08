package com._01_designPatternBasic.test04_interfaceIsolation;


public class Door1 implements GuardAgainstTheft, Fireproof, Waterproof {
    @Override
    public void fireproof() {
        System.out.print("防火");
    }

    @Override
    public void guard() {
        System.out.print("防盗");
    }

    @Override
    public void waterproof() {
        System.out.print("防水");
    }

    public void check() {
        System.out.print("功能：");
        fireproof();
        guard();
        waterproof();
        System.out.println();
    }
}
