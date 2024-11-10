package com.experiment01._01_abstractFactoryPattern.factory;

import com.experiment01._01_abstractFactoryPattern.product.AbstractCPU;
import com.experiment01._01_abstractFactoryPattern.product.AbstractRAM;
import com.experiment01._01_abstractFactoryPattern.product.PcCPU;
import com.experiment01._01_abstractFactoryPattern.product.PcRAM;

public class PcFactory implements AbstractFactory {
    @Override
    public AbstractCPU createCPU() {
        return new PcCPU();
    }

    @Override
    public AbstractRAM createRAM() {
        return new PcRAM();
    }
}
