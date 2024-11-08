package _04_observerPattern.test01.subject;

// 抽象主题（被观察） -- 微信公众号

import _04_observerPattern.test01.observer.AbstractUser;

public interface OfficialAccounts {
    // 添加用户（观察者）
    public void addUser(AbstractUser user);

    // 删除用户（观察者）
    public void removeUser(AbstractUser user);

    // 提醒所有用户
    public void notifyUser();
}
