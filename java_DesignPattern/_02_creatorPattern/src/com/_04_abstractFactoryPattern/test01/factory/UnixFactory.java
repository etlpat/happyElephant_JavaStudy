package com._04_abstractFactoryPattern.test01.factory;

import com._04_abstractFactoryPattern.test01.product.AbstractButton;
import com._04_abstractFactoryPattern.test01.product.AbstractText;
import com._04_abstractFactoryPattern.test01.product.UnixButton;
import com._04_abstractFactoryPattern.test01.product.UnixText;

// 生产Unix产品组
public class UnixFactory implements AbstractFactory {
    @Override
    public AbstractText createText() {
        return new UnixText();
    }

    @Override
    public AbstractButton createButton() {
        return new UnixButton();
    }
}
