package com._04_bridgePattern.test01.os;

import com._04_bridgePattern.test01.videoFile.VideoFile;

public class Mac extends OS {
    public Mac(VideoFile videoFile) {
        super(videoFile);
        setName("Mac");
    }
}
