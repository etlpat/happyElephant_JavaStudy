package com._04_abstractFactoryPattern.test01.factory;

import com._04_abstractFactoryPattern.test01.product.WindowsText;
import com._04_abstractFactoryPattern.test01.product.AbstractButton;
import com._04_abstractFactoryPattern.test01.product.AbstractText;
import com._04_abstractFactoryPattern.test01.product.WindowsButton;

// 生产Windows产品组
public class WindowsFactory implements AbstractFactory {
    @Override
    public AbstractText createText() {
        return new WindowsText();
    }

    @Override
    public AbstractButton createButton() {
        return new WindowsButton();
    }
}
