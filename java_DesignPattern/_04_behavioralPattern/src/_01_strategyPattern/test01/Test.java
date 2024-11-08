package _01_strategyPattern.test01;

// 案例：促销活动
//  一家百货公司在定年度的促销活动。
//  针对不同的节日(春节、中秋节、圣诞节)推出不同的促销活动,
//  由促销员将促销活动展示给客户。
//
// 案例分析：
//  抽象策略类 -- 促销类：SalesPromotion
//  具体策略类：春节促销SpringFestivalPromotion、
//          中秋促销MidAutumnFestivalPromotion、
//          圣诞促销ChristmasPromotion
//  环境类：销售员SalesMan（内部聚合一种销售策略，在sell()方法中使用这种策略）
//

import _01_strategyPattern.test01.context.SalesMan;
import _01_strategyPattern.test01.strategy.ChristmasPromotion;
import _01_strategyPattern.test01.strategy.MidAutumnFestivalPromotion;
import _01_strategyPattern.test01.strategy.SpringFestivalPromotion;

public class Test {
    public static void main(String[] args) {
        SalesMan salesMan = new SalesMan();

        // 给销售员设置“春节销售策略”
        salesMan.setSalesPromotion(new SpringFestivalPromotion());
        salesMan.sell();

        // 给销售员设置“中秋销售策略”
        salesMan.setSalesPromotion(new MidAutumnFestivalPromotion());
        salesMan.sell();

        // 给销售员设置“圣诞销售策略”
        salesMan.setSalesPromotion(new ChristmasPromotion());
        salesMan.sell();
    }
}
