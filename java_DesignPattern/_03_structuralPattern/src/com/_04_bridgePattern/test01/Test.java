package com._04_bridgePattern.test01;

// 案例：视频播放器
//  需要开发一个跨平台视频播放器,可以在不同操作系统平台(如windows、Mac、Linux等)上播放多种格式的视频文件,
//  常见的视频格式包括RMVB、AVI、WMV等。该播放器包含了两个维度,适合使用桥接模式
// 案例分析：
//  主体为OS，其子类为Windows、Mac、Linux
//  将抽象视频播放器VideoFile作为属性放入OS中，视频播放器的子类有RMVBVideoFile、AVIVideoFile、WMVVideoFile

import com._04_bridgePattern.test01.os.Linux;
import com._04_bridgePattern.test01.os.Mac;
import com._04_bridgePattern.test01.os.Windows;
import com._04_bridgePattern.test01.videoFile.AVIVideoFile;
import com._04_bridgePattern.test01.videoFile.RMVBVideoFile;
import com._04_bridgePattern.test01.videoFile.WMVVideoFile;

public class Test {
    public static void main(String[] args) {
        // 测试桥接模式
        Windows windows = new Windows(new AVIVideoFile());
        windows.playVideo();

        Mac mac = new Mac(new WMVVideoFile());
        mac.playVideo();

        Linux linux = new Linux(new RMVBVideoFile());
        linux.playVideo();
    }
}
