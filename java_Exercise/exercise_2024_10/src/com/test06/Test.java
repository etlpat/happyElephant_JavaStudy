package com.test06;

public class Test {
    public static void main(String[] args) {
        AgentBusinessSystem agentBusinessSystem = new AgentBusinessSystem("张三");

        agentBusinessSystem.run();
        agentBusinessSystem.run();
        agentBusinessSystem.run();

        System.out.println("\n=========日志信息=========");
        System.out.println(agentBusinessSystem.getLog());
    }
}
