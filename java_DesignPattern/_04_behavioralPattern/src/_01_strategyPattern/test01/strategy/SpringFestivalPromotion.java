package _01_strategyPattern.test01.strategy;

public class SpringFestivalPromotion implements SalesPromotion {
    @Override
    public void showPromotion() {
        System.out.println("春节销售策略~~");
    }
}
