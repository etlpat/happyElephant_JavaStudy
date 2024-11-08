package _01_strategyPattern.test01.context;

// 环境类--销售员
//  用于展示某种销售策略

import _01_strategyPattern.test01.strategy.SalesPromotion;

public class SalesMan {
    // 销售员内部聚合销售策略
    private SalesPromotion salesPromotion;

    public SalesMan() {
    }

    public SalesMan(SalesPromotion salesPromotion) {
        this.salesPromotion = salesPromotion;
    }


    // 销售类，用于展示销售策略，并贩卖商品
    public void sell() {
        if (salesPromotion == null) {
            System.out.println("销售员贩卖商品，无任何促销。");
            return;
        }

        System.out.print("销售员贩卖商品，本次销售策略是：");
        salesPromotion.showPromotion();
    }


    public SalesPromotion getSalesPromotion() {
        return salesPromotion;
    }

    public void setSalesPromotion(SalesPromotion salesPromotion) {
        this.salesPromotion = salesPromotion;
    }
}
