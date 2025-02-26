package com.chatRoom.javaBean;

import java.awt.*;
import java.io.Serializable;


// 艺术字对象，用于存放字体
// P.S.也可用于存放图片
public class FontStyle implements Serializable {// 序列化，用于IO传输
    String path;// 图片路径【表示该对象是图片】
    String content;// 文字内容【表示该对象是文字】
    String fontFamily;// 文字字体
    int size;// 文字大小
    Color color;// 文字颜色
    int fontStyle;// 字的样式

    public FontStyle(String content) {
        this.content = content;
    }

    public FontStyle() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public void setFontFamily(String fontFamily) {
        this.fontFamily = fontFamily;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getFontStyle() {
        return fontStyle;
    }

    public void setFontStyle(int fontStyle) {
        this.fontStyle = fontStyle;
    }

    @Override
    public String toString() {
        return "FontStyle{" +
                "path='" + path + '\'' +
                ", content='" + content + '\'' +
                ", fontFamily='" + fontFamily + '\'' +
                ", size=" + size +
                ", color=" + color +
                ", fontStyle=" + fontStyle +
                '}';
    }
}
