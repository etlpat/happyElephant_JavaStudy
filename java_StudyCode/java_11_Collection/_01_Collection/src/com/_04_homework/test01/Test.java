package com._04_homework.test01;

// 按要求实现:
//  (1)封装一个新闻类,包含标题和内容属性,提供get、set方法,重写toString方法,打印对象时只打印标题;
//  (2)只提供一个带参数的构造器,实例化对象时,只初始化标题;并且实例化两个对象:
//      新闻一:新冠确诊病例超千万,数百万印度教信徒赴恒河“圣浴”引民众担忧
//      新闻二:男子突然想起2个月前钓的鱼还在网兜里,捞起一看赶紧放生
//  (3)将新闻对象添加到ArrayList集合中,并且进行倒序遍历;
//  (4)在遍历集合过程中,对新闻标题进行处理,超过15字的只保留前15个,然后在后边加“ …. ”
//  (5)在控制台打印遍历出经过处理的新闻标题;


import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        News news1 = new News("新闻一:新冠确诊病例超千万,数百万印度教信徒赴恒河“圣浴”引民众担忧");
        News news2 = new News("新闻二:男子突然想起2个月前钓的鱼还在网兜里,捞起一看赶紧放生");
        News news3 = new News("新闻三:韭菜盒子，好吃开胃");
        ArrayList<News> newsArrayList = new ArrayList<>();

        newsArrayList.add(news1);
        newsArrayList.add(news2);
        newsArrayList.add(news3);


        // 倒叙遍历ArrayList
        for (int i = newsArrayList.size() - 1; i >= 0; i--) {
            String oldNewsString = newsArrayList.get(i).toString();
            // 截取标题的前15个字符，并加上"..."
            String newNewsString = oldNewsString.length() > 15 ?
                    oldNewsString.substring(0, 15) + "..." : oldNewsString;
            System.out.println(newNewsString);
        }

    }
}
