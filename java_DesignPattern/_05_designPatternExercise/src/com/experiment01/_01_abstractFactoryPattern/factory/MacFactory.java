package com.experiment01._01_abstractFactoryPattern.factory;

import com.experiment01._01_abstractFactoryPattern.product.AbstractCPU;
import com.experiment01._01_abstractFactoryPattern.product.AbstractRAM;
import com.experiment01._01_abstractFactoryPattern.product.MacCPU;
import com.experiment01._01_abstractFactoryPattern.product.MacRAM;

public class MacFactory implements AbstractFactory {
    @Override
    public AbstractCPU createCPU() {
        return new MacCPU();
    }

    @Override
    public AbstractRAM createRAM() {
        return new MacRAM();
    }
}
