package _04_observerPattern.test01.observer;

// 具体观察者 -- 用户

public class User extends AbstractUser {
    public User() {
    }

    public User(String name) {
        super(name);
    }

    // 实现update()方法，响应主题类的变化
    @Override
    public void update() {
        System.out.println("用户“" + getName() + "”收到公众号的通知，正在浏览！");
    }
}
