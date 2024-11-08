package _01_strategyPattern.test01.strategy;

public class MidAutumnFestivalPromotion implements SalesPromotion {
    @Override
    public void showPromotion() {
        System.out.println("中期销售策略~~");
    }
}
