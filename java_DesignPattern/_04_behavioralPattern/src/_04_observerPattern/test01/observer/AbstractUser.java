package _04_observerPattern.test01.observer;

// 抽象观察者 -- 抽象用户

public abstract class AbstractUser {
    private String name;

    public AbstractUser() {
    }

    public AbstractUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    // 主题类发生变化，观察者调用update()方法进行更新
    public abstract void update();
}
