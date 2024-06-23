package com.airplaneWar;


import com.airplaneWar.game.gameMian.GameStart;
import com.airplaneWar.javaBean.LoginUser;
import com.airplaneWar.javaBean.UserScore;
import com.airplaneWar.userInterface.AfterGameMenu;
import com.airplaneWar.userInterface.LoginFrame;


public class Main {
    // flag为false，表示游戏未开启
    public static boolean flag = false;
    // loginUser用于获取本次开启游戏的loginUser
    public static LoginUser loginUser = null;

    public static void main(String[] args) {
        // 创建登录界面
        new LoginFrame();


        // 死循环，等待游戏开始
        while (true) {
            // 当flag变为true，开启游戏
            if (flag) {
                new GameStart().launch();
                break;
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }


        // 死循环，等待游戏结束
        while (true) {
            // 当flag变为false，游戏结束
            if (flag == false) {
                // 获取游戏分数对象
                UserScore userScore = new UserScore(loginUser.getUsername(),
                        loginUser.getPassword(), GameStart.score, GameStart.num);
                System.out.println(GameStart.score);
                System.out.println(GameStart.num);
                // 创建游戏结束菜单
                new AfterGameMenu(userScore);
                break;
            }

            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
