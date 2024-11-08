package com._04_bridgePattern.test01.os;

import com._04_bridgePattern.test01.videoFile.VideoFile;

public class Windows extends OS {
    public Windows(VideoFile videoFile) {
        super(videoFile);
        setName("Windows");
    }
}
