package com.test06;

import java.util.Scanner;

public class AgentBusinessSystem {
    private String agentName;
    private BusinessSystem businessSystem;
    private String log = "";
    private static int count = 0;


    public AgentBusinessSystem(String agentName) {
        this.agentName = agentName;
        businessSystem = new BusinessSystem();
    }

    // 身份验证
    public boolean identityAuthentication(String username) {
        return agentName.equals(username);
    }

    // 日志记录
    public void logRecording() {
        log += "第" + (++count) + "次 " + agentName + " 访问商务系统\n";
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String userName = scanner.next();

        // 身份验证
        boolean b = identityAuthentication(userName);
        if (b) {
            // 查询商务系统
            businessSystem.informationQuery();
            // 记录日志
            logRecording();
        } else {
            System.out.println("身份验证失败");
        }
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public BusinessSystem getBusinessSystem() {
        return businessSystem;
    }

    public void setBusinessSystem(BusinessSystem businessSystem) {
        this.businessSystem = businessSystem;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        AgentBusinessSystem.count = count;
    }
}
