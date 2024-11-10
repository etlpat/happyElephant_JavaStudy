package com.experiment01._01_abstractFactoryPattern.factory;

import com.experiment01._01_abstractFactoryPattern.product.AbstractCPU;
import com.experiment01._01_abstractFactoryPattern.product.AbstractRAM;

public interface AbstractFactory {
    public AbstractCPU createCPU();

    public AbstractRAM createRAM();
}
