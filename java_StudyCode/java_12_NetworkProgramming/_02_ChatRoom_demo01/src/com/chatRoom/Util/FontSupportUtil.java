package com.chatRoom.Util;

import com.chatRoom.javaBean.FontStyle;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;


// 用于处理字体的工具类
public class FontSupportUtil {

    // (1)包装字体的方法（为字体添加样式）
    // 参数：输入框,文字颜色,字体,文字样式,文字大小
    public static void setFont(JTextPane txtSent, Color color,
                               String fontFamily, int fontStyle, int fontSize) {
        // 获取输入框中内容
        Document document = txtSent.getDocument();

        try {
            // ①设置文字样式
            // 添加一个可以设置样式的类
            StyleContext sc = StyleContext.getDefaultStyleContext();
            // 创建字体样式类，并将参数赋给它
            AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
                    StyleConstants.Foreground, color);
            Font font = new Font(fontFamily, fontStyle, fontSize);
            // 为添加的样式类添加字体
            aset = sc.addAttribute(aset, StyleConstants.Family, font.getFamily());
            // 设置字体的大小
            aset = sc.addAttribute(aset, StyleConstants.FontSize, fontSize);
            // 若是粗体，设为粗体
            if (fontStyle == Font.BOLD) {
                aset = sc.addAttribute(aset, StyleConstants.Bold, true);
            }
            // 若是斜体，设为斜体
            if (fontStyle == Font.ITALIC) {
                aset = sc.addAttribute(aset, StyleConstants.Italic, true);
            }
            // 若不加粗/倾斜，取消字体加粗/倾斜
            if (fontStyle == Font.PLAIN) {
                aset = sc.addAttribute(aset, StyleConstants.Bold, false);
                aset = sc.addAttribute(aset, StyleConstants.Italic, false);
            }

            // ②将所选中字符串，转换为对应样式的字体
            // 截取输入框中被选择的字符串
            int start = txtSent.getSelectionStart();
            int end = txtSent.getSelectionEnd();
            String str = document.getText(start, end - start);// 截取字串
            // 移除原本的旧字符串
            document.remove(start, end - start);
            // 在此处插入添加样式后的新字符串
            document.insertString(start, str, aset);

        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }


    // (2)将发送框中的艺术字字符串，存放到实体类FontStyle的列表中
    // 注意：每一个艺术字，对应一个FontStyle对象
    public static List<FontStyle> paneTxtToFontStyleList(JTextPane textPane) {
        Document document = textPane.getDocument();
        List<FontStyle> fontStyles = new ArrayList<>();

        // 遍历输入框中的文本，将其转换为FontStyle对象
        for (int i = 0; i < document.getLength(); i++) {// 遍历输入框内容
            try {
                StyledDocument sd = textPane.getStyledDocument();
                // 为每个文字/图片创建一个对应的FontStyle对象
                FontStyle fontStyle = new FontStyle();
                Element e = sd.getCharacterElement(i);

                if (e instanceof AbstractDocument.LeafElement) {
                    // ①假如该对象是文字
                    if (e.getName().equals("content")) {
                        // 将该艺术字封装到FontStyle对象中
                        AttributeSet as = e.getAttributes();
                        // 设置文字的属性
                        fontStyle.setContent(sd.getText(i, 1));
                        fontStyle.setFontFamily(as.getAttribute(StyleConstants.Family).toString());
                        fontStyle.setSize((Integer) as.getAttribute(StyleConstants.FontSize));
                        fontStyle.setFontStyle((Integer) as.getAttribute(StyleConstants.FontSize));
                        fontStyle.setColor((Color) as.getAttribute(StyleConstants.Foreground));
                        if (StyleConstants.isBold(as)) {
                            fontStyle.setFontStyle(Font.BOLD);
                        } else if (StyleConstants.isItalic(as)) {
                            fontStyle.setFontStyle(Font.ITALIC);
                        } else {
                            fontStyle.setFontStyle(Font.PLAIN);
                        }
                    }
                    // ②假如该对象是图片
                    else if (e.getName().equals("icon")) {
                        // 将图片的路径设置到fontStyle对象中
                        fontStyle.setPath(e.getAttributes().getAttribute(StyleConstants.IconAttribute).toString());
                    }
                }

                // 将封装的对象添加到列表中
                fontStyles.add(fontStyle);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fontStyles;
    }


    // (3)将普通字符串转换为FontStyle列表
    public static List<FontStyle> stringToFontStyleList(String string) {
        ArrayList<FontStyle> fontStyles = new ArrayList<>();

        for (int i = 0; i < string.length(); i++) {
            // 创建字体对象，并赋默认值
            FontStyle fontStyle = new FontStyle(string.charAt(i) + "");
            fontStyle.setFontFamily("宋体");
            fontStyle.setSize(16);
            fontStyle.setColor(Color.BLACK);

            fontStyles.add(fontStyle);
        }
        return fontStyles;
    }


    // (4)将FontStyle列表中的内容，打印到输出框中
    //  （将列表中数据，拼接到输出框末尾）
    public static void fontStyleListToPane(JTextPane textPane, List<FontStyle> fontStyles) {
        // 创建可以设置样式的类
        StyleContext sc = StyleContext.getDefaultStyleContext();
        // 获取输出框的内容对象
        Document document = textPane.getDocument();

        // 遍历FontStyle列表（将文字/图片一个一个打印到输出框中）
        for (FontStyle fontStyle : fontStyles) {
            if (fontStyle != null) {
                if (fontStyle.getContent() != null) {// 若本对象是文字对象（内容不为空）
                    try {
                        // 创建字体样式类，并将本轮字体的颜色赋给它
                        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, fontStyle.getColor());
                        // 创建字体对象，并赋值
                        Font font = new Font(fontStyle.getFontFamily(), fontStyle.getFontStyle(), fontStyle.getSize());
                        // 为添加的样式类添加字体
                        aset = sc.addAttribute(aset, StyleConstants.Family, font.getFamily());

                        // 设置字体的大小
                        aset = sc.addAttribute(aset, StyleConstants.FontSize, fontStyle.getSize());
                        // 设置字体是否加粗
                        if (fontStyle.getFontStyle() == Font.BOLD) {
                            aset = sc.addAttribute(aset, StyleConstants.Bold, true);
                        }
                        // 设置字体是否倾斜
                        if (fontStyle.getFontStyle() == Font.ITALIC) {
                            aset = sc.addAttribute(aset, StyleConstants.Italic, true);
                        }
                        // 设置字体是否取消加粗/倾斜
                        if (fontStyle.getFontStyle() == Font.PLAIN) {
                            aset = sc.addAttribute(aset, StyleConstants.Bold, false);
                            aset = sc.addAttribute(aset, StyleConstants.Italic, false);
                        }

                        // 将以上文字（艺术字），插入到输出框末尾！
                        document.insertString(document.getLength(), fontStyle.getContent(), aset);

                    } catch (Exception e) {
                        e.printStackTrace();

                    }

                } else {// 若本对象是图片对象

                    // 将光标移动到接收框末尾
                    textPane.setCaretPosition(document.getLength());
                    // 将图片插入到接收框中
                    textPane.insertIcon(new ImageIcon(fontStyle.getPath()));
                }
            }
        }
        textPane.setCaretPosition(document.getLength());// 将光标置到末尾
    }


}