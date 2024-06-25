package com.airplaneWar.sound;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;

public class PlayGameBgmSound {
    // 音频文件的路径
    public static String bgmPath = "sound/airplaneWarBgm.wav";


    public static Clip playSound() {
        try {
            // 加载音乐文件
            File bgmFile = new File(bgmPath);
            // 将音乐文件转为url
            URL bgmUrl = bgmFile.toURI().toURL();

            // 获取音乐的音频对象
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bgmUrl);
            // 获取音乐播放器对象
            Clip clip = AudioSystem.getClip();

            // 使音乐播放器开始播放该音频
            clip.open(audioInputStream);
            // 设置音乐循环播放
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // 返回音乐播放器
            return clip;

            // 之后调用clip.close()即可停止播放音乐
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 若异常，返回null
        return null;
    }
}
