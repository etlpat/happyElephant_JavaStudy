// polymorphic parameter：多态参数

// 多态参数
// (1)概念：
//      方法定义的形参类型为父类类型，实参允许为子类类型
// (2)多态参数的好处：
//      方法形参是父类，实参可以传入多种子类，减少代码复用
//      若不用多态对象做参数，只能将方法多次重载，代码复用较多


package com._07_polyParameter;

// 案例：①定义员工类Employee，包含私有属性属性name和月薪salary，以及返回年薪getAnnual方法
//         定义工人Worker类继承Employee，新增work方法
//         定义经理Manager继承Employee，新增属性奖金bonus和管理manage方法，并重写getAnnual方法
//      ②在测试类中添加showEmpAnnual方法，多态调用员工及其子类对象的getAnnual方法
//         测试类中定义toWork方法，若是工人调用work，若是经理调用manage


public class PolyParameter {
    // 传入父类引用，调用重写方法
    public void showEmpAnnual(Employee emp) {
        System.out.println(emp.getName() + " 年薪为：" + emp.getAnnual());// 方法和运行类型动态绑定
    }

    // 传入父类引用，调用子类对象特有方法
    public void toWork(Employee emp) {
        if (emp instanceof Worker) {// 先判断运行类型
            ((Worker) emp).work();// 然后向下转型，调用子类特有方法
        } else if (emp instanceof Manager) {
            ((Manager) emp).manage();
        }
    }


    public static void main(String[] args) {
        Employee[] empArr = new Employee[3];
        empArr[0] = new Manager("阿福", 9980, 37000);
        empArr[1] = new Worker("张三", 5100);
        empArr[2] = new Worker("李四", 4700);
        PolyParameter pp = new PolyParameter();


        // 调用多态参数的方法
        for (int i = 0; i < empArr.length; i++) {
            pp.showEmpAnnual(empArr[i]);
        }
//        阿福 年薪为：156760.0
//        张三 年薪为：61200.0
//        李四 年薪为：56400.0

        for (int i = 0; i < empArr.length; i++) {
            pp.toWork(empArr[i]);
        }
//        Manager阿福 在管理...
//        Worker张三 在工作...
//        Worker李四 在工作...
    }
}
