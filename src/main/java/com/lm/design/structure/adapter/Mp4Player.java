package com.lm.design.structure.adapter;


/**
 * @Author: limeng
 * @Date: 2019/5/1 9:12
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Player mp4 file. Name:"+fileName);
    }
}
