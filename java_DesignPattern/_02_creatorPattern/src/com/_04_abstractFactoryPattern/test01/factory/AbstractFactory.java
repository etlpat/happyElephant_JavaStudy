package com._04_abstractFactoryPattern.test01.factory;

// 每个产品组中，包含Text和Button

import com._04_abstractFactoryPattern.test01.product.AbstractText;
import com._04_abstractFactoryPattern.test01.product.AbstractButton;

public interface AbstractFactory {
    // 生产Text对象
    public AbstractText createText();

    // 生成Button对象
    public AbstractButton createButton();
}
