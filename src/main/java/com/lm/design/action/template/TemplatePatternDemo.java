package com.lm.design.action.template;

/**
 * @Author: limeng
 * @Date: 2019/5/25 17:10
 */
public class TemplatePatternDemo {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.play();
        System.out.println();
        game = new Football();
        game.play();
    }
}
