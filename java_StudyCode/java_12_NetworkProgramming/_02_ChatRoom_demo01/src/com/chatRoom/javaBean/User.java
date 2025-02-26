package com.chatRoom.javaBean;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

// 实体类User通过io流传输，必须继承Serializable序列化接口
public class User implements Serializable {
    private String username;
    private String password;

    private boolean isExist = false;// 用于判断用户是否存在
    private Object notice;// 用户携带的系统消息
    private List<FontStyle> chatContent;// 用户的聊天消息内容
    private ChatStatus chatStatus;// 枚举类型消息状态
    private String sender;// 发送人
    private String receiver;// 接收人
    private byte[] fileBytes;// 文件的字节数组
    private String fileName;// 文件名


    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", isExist=" + isExist +
                ", notice=" + notice +
                ", chatContent=" + chatContent +
                ", chatStatus=" + chatStatus +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", fileBytes=" + Arrays.toString(fileBytes) +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    public byte[] getFileBytes() {
        return fileBytes;
    }

    public void setFileBytes(byte[] fileBytes) {
        this.fileBytes = fileBytes;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }

    public Object getNotice() {
        return notice;
    }

    public void setNotice(Object notice) {
        this.notice = notice;
    }

    public ChatStatus getChatStatus() {
        return chatStatus;
    }

    public void setChatStatus(ChatStatus chatStatus) {
        this.chatStatus = chatStatus;
    }

    public List<FontStyle> getChatContent() {
        return chatContent;
    }

    public void setChatContent(List<FontStyle> chatContent) {
        this.chatContent = chatContent;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
