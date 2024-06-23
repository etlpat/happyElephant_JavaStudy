package com.airplaneWar.jdbc;


import com.airplaneWar.javaBean.User;
import com.airplaneWar.javaBean.UserScore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


// DAO类用于实现数据库的CRUD
// 注意：每个C/R/U/D方法中都要完整的包含JDBC的流程

public class DAO {

    // 向数据库的airplaneUsers表添加元素
    public static boolean insertAirplaneUsers(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 获取连接对象
            conn = JDBCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql语言
            String sql = "insert into airplaneUsers values('"
                    + user.getUsername() + "','"
                    + user.getPassword() + "','"
                    + user.getSex() + "','"
                    + user.getLevel() + "')";
            int num = stmt.executeUpdate(sql);
            // 处理结果
            if (num > 0) {
                // 若修改的行数>0，说明DB语句执行成功
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JDBCUtil.myClose(conn, stmt, null);
        }
        return false;
    }


    // 获取包含airplaneUsers表全部元素的列表
    public static ArrayList<User> getAirplaneUsersAll() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获取连接对象
            conn = JDBCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql语言
            String str = "select * from airplaneUsers";
            stmt.execute(str);
            // 处理结果集
            rs = stmt.getResultSet();
            ArrayList<User> users = new ArrayList<>();// 定义列表，用于存储数据库的行信息
            while (rs.next()) {
                users.add(new User(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("sex"),
                        rs.getString("level")));
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


    // 向数据库的airplaneScoreBoard表添加元素
    public static boolean insertAirplaneScoreBoard(UserScore userScore) {
        Connection conn = null;
        Statement stmt = null;
        // 获取当前的"yyyy-MM-dd HH:mm:ss"格式的Date数据
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        try {
            // 获取连接对象
            conn = JDBCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql语言
            String sql = "insert into airplaneScoreBoard values('"
                    + userScore.getUsername() + "','"
                    + date + "',"
                    + userScore.getScore() + ","
                    + userScore.getFlyDistance() + ")";
            int num = stmt.executeUpdate(sql);
            // 处理结果
            if (num > 0) {
                // 若修改的行数>0，说明DB语句执行成功
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JDBCUtil.myClose(conn, stmt, null);
        }
        return false;
    }


    // 以score降序排序，获取airplaneScoreBoard表中，指定用户名的全部数据的列表
    public static ArrayList<UserScore> getAirplaneScoreByOrder(String username) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            // 获取连接对象
            conn = JDBCUtil.myGetConnection();
            // 获取通道对象
            stmt = conn.createStatement();
            // 执行sql语言
            String str = "SELECT * FROM airplaneScoreBoard " +
                    "WHERE username = '" + username + "' " +
                    "ORDER BY score DESC;";
            stmt.execute(str);
            // 处理结果集
            rs = stmt.getResultSet();
            ArrayList<UserScore> userScores = new ArrayList<>();// 定义列表，用于存储数据库的行信息
            while (rs.next()) {
                userScores.add(new UserScore(rs.getString("username"),
                        rs.getString("gameDateTime"),
                        rs.getInt("score"),
                        rs.getInt("flyDistance")));
            }
            return userScores;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            // 关闭资源
            JDBCUtil.myClose(conn, stmt, rs);
        }
        return null;
    }
}
