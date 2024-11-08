package _04_observerPattern.test01.subject;

import _04_observerPattern.test01.observer.AbstractUser;

import java.util.ArrayList;

// 具体主题类 -- “程序员公众号”

public class ProgrammerPublicAccount implements OfficialAccounts {
    // 具体主题类中，使用集合来容纳观察者
    ArrayList<AbstractUser> users = new ArrayList<>();

    // 添加观察者
    @Override
    public void addUser(AbstractUser user) {
        users.add(user);
    }

    // 删除观察者
    @Override
    public void removeUser(AbstractUser user) {
        users.remove(user);
    }


    // 当主题类发生变化，提醒所有观察者
    @Override
    public void notifyUser() {
        System.out.println("提醒所有观察者：公众号更新了~~");

        // 遍历所有观察者，调用对应的update()方法进行更新
        for (AbstractUser user : users) {
            user.update();
        }
    }
}
