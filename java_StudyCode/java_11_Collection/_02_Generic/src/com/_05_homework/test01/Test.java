package com._05_homework.test01;

// 测试案例：
//  定义个泛型类DAO<T>,在其中定义一个Map成员变量,Map的键为String类型,值为T类型。
//  分别创建以下方法:
//      (1) public void save(String id,T entity):保存T类型的对象到Map成员变量中
//      (2) public T get(String id):从map 中获取id 对应的对象
//      (3) public void update(String id,T entity):替换map中key为id的内容,改为entity 对象
//      (4)public List<T>list():返回map中存放的所有T对象
//      (5) public void delete(String id):删除指定id对象
//  定义一个User类:
//      该类包含:private成员变量(int类型)id,age;(String类型)name。
//  创建DAO类的对象,分别调用其save、get、update、list、delete 方法来操作User对象,
//  使用JUnit单元测试类进行测试。
//


import java.util.List;

public class Test {
    public static void main(String[] args) {
        User user1 = new User("0001", "张三", 18);
        User user2 = new User("0002", "李四", 28);
        User user3 = new User("0003", "王五", 17);
        DAO<User> userDAO = new DAO<>();

        // save
        userDAO.save(user1.getId(), user1);
        userDAO.save(user2.getId(), user2);
        userDAO.save(user3.getId(), user3);
        System.out.println(userDAO);
        System.out.println("=================================");

        // get
        User tmp = userDAO.get(user1.getId());
        System.out.println(tmp);
        System.out.println("=================================");

        // update
        User user4 = new User(user2.getId(), "赵六", 47);
        userDAO.update(user2.getId(), user4);
        System.out.println(userDAO);
        System.out.println("=================================");

        // list
        List<User> list = userDAO.list();
        System.out.println(list.getClass().getSimpleName());
        System.out.println(list);
        System.out.println("=================================");

        // delete
        userDAO.delete(user1.getId());
        System.out.println(userDAO);

    }
}
