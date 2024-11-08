package com._01_designPatternBasic.test05_demeterRule;

// 案例：明星与经纪人的关系实例
//  明星由于全身心投入艺术,所以许多日常事务由经纪人负责处理,
//  如和粉丝的见面会,和媒体公司的业务洽淡等。
//  这里的经纪人是明星的朋友,而粉丝和媒体公司是陌生人,所以适合使用迪米特法则。
//

public class Test {
    public static void main(String[] args) {
        Star star = new Star("成龙");
        Agent agent = new Agent(star);

        agent.addFans(new Fans("张三"));
        agent.addFans(new Fans("李四"));
        agent.addFans(new Fans("王五"));

        agent.addCompany(new Company("贪玩蓝月"));
        agent.addCompany(new Company("传奇"));


        // 经纪人处理明星和粉丝的关系
        agent.dealStarsAndFans();
        System.out.println("============");
        // 经纪人处理明星和公司的关系
        agent.dealStarsAndCompany();

    }
}
