package com.airplaneWar.service;


import com.airplaneWar.javaBean.LoginUser;
import com.airplaneWar.javaBean.User;
import com.airplaneWar.jdbc.DAO;

import java.util.ArrayList;


// 用于处理登录、注册时的各种判断
public class Service {

    // 方法：判断注册信息是否重复
    // （判断用户名是否在数据库中重名）
    public static boolean isRegisterInfoCorrect(User user) {
        ArrayList<User> users = DAO.getAirplaneUsersAll();

        // 若users为空，注册成功
        if (users == null || users.size() == 0) {
            return true;
        }

        // 遍历注册信息表中的所有用户名
        for (User user1 : users) {
            if (user1.getUsername().equals(user.getUsername())) {
                // 若用户名重复，返回false
                return false;
            }
        }
        // 若用户名不重复，返回true
        return true;
    }


    // 方法：判断登录信息设否正确
    public static boolean isLoginInfoCorrect(LoginUser user) {
        ArrayList<User> users = DAO.getAirplaneUsersAll();

        // 若users为空，登录失败
        if (users == null || users.size() == 0) {
            return false;
        }

        // 遍历注册信息表中的所有用户
        for (User user1 : users) {
            // 若登录用户名和密码，与注册信息表中的用户相同，返回true
            if (user1.getUsername().equals(user.getUsername())
                    && user1.getPassword().equals(user.getPassword())) {
                return true;
            }
        }

        // 若登录信息与表中所有用户均不同，返回false
        return false;
    }

}
