package com.chatRoom.jdbc;

import com.chatRoom.javaBean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


// DAO类用于实现数据库的CRUD
// 注意：每个C/R/U/D方法中都要完整的包含JDBC的流程

public class DAO {

    // 获取user表的所有行
    public static ArrayList<User> getAllUsers() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获取连接对象
            conn = JDBCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql语言
            String str = "select * from user";
            stmt.execute(str);
            // 处理结果集
            rs = stmt.getResultSet();
            ArrayList<User> users = new ArrayList<>();// 定义列表，用于存储数据库的行信息
            while (rs.next()) {
                users.add(new User(rs.getString("username"),
                        rs.getString("password")));
            }
            return users;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JDBCUtil.myClose(conn, stmt, rs);
        }
        return null;
    }

    // 查询账号密码是否存在
    public static boolean isUserExist(User user) {
        ArrayList<User> users = getAllUsers();
        for (User u : users) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getAllUsers());
    }
}
