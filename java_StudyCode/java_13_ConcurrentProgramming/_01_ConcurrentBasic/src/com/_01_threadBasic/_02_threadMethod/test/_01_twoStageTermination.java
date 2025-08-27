package com._01_threadBasic._02_threadMethod.test;

// 案例：使用interrupt打断方法，实现两阶段终止

// 监控类
class Monitor {
    // 监控线程
    private Thread monitor;

    // 监控的业务逻辑
    private void monitorService() {
        System.out.println("正在监控中...");
    }

    // 开启监控线程，进行监控
    public void startMonitor() {
        if (monitor != null) {
            return;
        }
        monitor = new Thread(() -> {
            while (true) {
                // 若被打断，则退出循环
                if (Thread.currentThread().isInterrupted()) {
                    // 在此料理后事（释放线程资源等...）
                    break;
                }
                // 执行监控的业务逻辑
                monitorService();
                try {
                    Thread.sleep(1000);// 休眠1s
                } catch (InterruptedException e) {
                    // 若在休眠中被打断，则设打断标记为true
                    //  注意：此时已经结束阻塞，因此可以使用interrupt()设置打断标记！
                    Thread.currentThread().interrupt();
                }
            }
        });
        monitor.start();
        System.out.println("#!!监控开启!!#");
    }

    // 关闭监控线程，结束监控
    public void stopMonitor() throws InterruptedException {
        if (monitor != null) {
            monitor.interrupt();
            monitor.join();
            monitor = null;
            System.out.println("#!!监控结束!!#");
        }
    }
}


public class _01_twoStageTermination {
    public static void main(String[] args) throws InterruptedException {
        Monitor monitor = new Monitor();
        monitor.startMonitor();
        Thread.sleep(10000);
        monitor.stopMonitor();
    }
}
