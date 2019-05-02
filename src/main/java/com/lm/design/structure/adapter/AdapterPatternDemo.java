package com.lm.design.structure.adapter;

/**
 * 作为两个不兼容的接口之间的桥梁
 * @Author: limeng
 * @Date: 2019/5/1 9:29
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","beyond the horizon.mp3");
        audioPlayer.play("mp4","alone.mp4");
        audioPlayer.play("vlc","far far away.vlc");
        audioPlayer.play("avi","mind me.avi");
    }
}
