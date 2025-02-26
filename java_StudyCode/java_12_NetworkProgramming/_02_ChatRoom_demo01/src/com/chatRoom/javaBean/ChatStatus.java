package com.chatRoom.javaBean;

// 枚举类型，聊天状态，用于消息分类
public enum ChatStatus {
    LOGIN(1, "登录消息"),
    NOTICE(2, "系统消息"),
    CHAT(3, "聊天消息"),
    SHAKE(4, "抖动消息"),
    ULIST(5, "刷新在线列表");

    private int status;
    private String desc;

    ChatStatus(int status, String description) {
        this.status = status;
        this.desc = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
