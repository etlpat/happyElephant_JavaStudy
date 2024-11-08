package com._01_proxyPattern.test01;

// 代理类
// （添加了level作为级别，0表示游客，1表示用户）

// 继承抽象主题类
public class ProxyPermission extends AbstractPermission {
    // 代理类中，包含真实主题对象，方便调用方法
    private RealPermission realPermission = new RealPermission();
    private int level;

    public ProxyPermission() {
        this.level = 0;
    }

    public ProxyPermission(int level) {
        if (level == 0 || level == 1) {
            this.level = level;
        } else {
            System.out.println("该等级不存在，自动设为游客");
            this.level = 0;
        }
    }


    // 代理类：对真实主题类的方法做出功能扩展
    @Override
    public void modifyInformation() {
        if (level == 0) {
            System.out.println("游客没有这项权限，清注册用户信息！");
        } else if (level == 1) {
            realPermission.modifyInformation();
        }
    }

    @Override
    public void viewPost() {
        realPermission.viewPost();
    }

    @Override
    public void sendPost() {
        if (level == 0) {
            System.out.println("游客没有这项权限，清注册用户信息！");
        } else if (level == 1) {
            realPermission.sendPost();
        }
    }

    @Override
    public void modifyPost() {
        if (level == 0) {
            System.out.println("游客没有这项权限，清注册用户信息！");
        } else if (level == 1) {
            realPermission.modifyPost();
        }
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
