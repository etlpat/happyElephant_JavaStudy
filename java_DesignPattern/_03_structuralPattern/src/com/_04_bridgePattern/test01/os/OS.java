package com._04_bridgePattern.test01.os;

import com._04_bridgePattern.test01.videoFile.VideoFile;

public abstract class OS {
    private String name;
    // 将VideoFile封装成类，作为OS的属性
    private VideoFile videoFile;

    public OS(VideoFile videoFile) {
        this.videoFile = videoFile;
    }


    // 方法：播放视频
    public void playVideo() {
        System.out.println(getName() + "系统 正在播放 " + videoFile.getFileName() + "视频");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VideoFile getVideoFile() {
        return videoFile;
    }

    public void setVideoFile(VideoFile videoFile) {
        this.videoFile = videoFile;
    }
}
