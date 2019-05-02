package com.lm.design.structure.adapter;

import com.lm.design.structure.adapter.AdvancedMediaPlayer;

/**
 * @Author: limeng
 * @Date: 2019/5/1 9:11
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("Player vlc file.name: "+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
