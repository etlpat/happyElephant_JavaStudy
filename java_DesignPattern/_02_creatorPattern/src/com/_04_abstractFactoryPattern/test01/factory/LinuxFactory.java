package com._04_abstractFactoryPattern.test01.factory;

import com._04_abstractFactoryPattern.test01.product.AbstractButton;
import com._04_abstractFactoryPattern.test01.product.AbstractText;
import com._04_abstractFactoryPattern.test01.product.LinuxButton;
import com._04_abstractFactoryPattern.test01.product.LinuxTest;

// 生产Linux产品组
public class LinuxFactory implements AbstractFactory {
    @Override
    public AbstractText createText() {
        return new LinuxTest();
    }

    @Override
    public AbstractButton createButton() {
        return new LinuxButton();
    }
}
