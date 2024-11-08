package _04_observerPattern.test01;

// 案例：微信公众号
//  在使用微信公众号时,大家都会有这样的体验,当你关注的公众号中有新内容更新的话,它就会推送给关注公众号的微信用户端。
//  我们使用观察者模式来模拟这样的场景,微信用户就是观察者,微信公众号是被观察者,有多个的微信用户关注了程序猿这个公众号。
//

import _04_observerPattern.test01.observer.User;
import _04_observerPattern.test01.subject.OfficialAccounts;
import _04_observerPattern.test01.subject.ProgrammerPublicAccount;

public class Test {
    public static void main(String[] args) {
        // 创建公众号对象（主题类）
        OfficialAccounts officialAccounts = new ProgrammerPublicAccount();

        // 向公众号添加用户（观察者）
        officialAccounts.addUser(new User("张三"));
        officialAccounts.addUser(new User("李四"));
        officialAccounts.addUser(new User("王五"));

        // 公众号发送新帖子
        //  （并提醒所有观察者，调用所有观察者的update()方法进行响应）
        officialAccounts.notifyUser();
    }
}
