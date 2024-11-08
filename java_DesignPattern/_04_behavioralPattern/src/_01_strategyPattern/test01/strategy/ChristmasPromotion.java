package _01_strategyPattern.test01.strategy;

public class ChristmasPromotion implements SalesPromotion {
    @Override
    public void showPromotion() {
        System.out.println("圣诞销售策略~~");
    }
}
