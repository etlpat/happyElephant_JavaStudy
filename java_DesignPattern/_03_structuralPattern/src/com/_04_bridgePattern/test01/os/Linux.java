package com._04_bridgePattern.test01.os;

import com._04_bridgePattern.test01.videoFile.VideoFile;

public class Linux extends OS {
    public Linux(VideoFile videoFile) {
        super(videoFile);
        setName("Linux");
    }
}
