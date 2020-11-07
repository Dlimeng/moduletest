package com.lm.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Classname DemoTest
 * @Description TODO
 * @Date 2020/11/4 15:49
 * @Created by limeng
 */
public class DemoTest {
    public static void main(String[] args) {
        int cap = 2;

        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;

        System.out.println(n);


//        try {
//            System.out.println(new String(Base64.getDecoder().decode("a25vd0AyMDE4".getBytes()),"UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        /**
         * know@2018
         * a25vd0AyMDE4
         * know@2018
         */
//        final String xml = "know@2018";
//        final byte[] xmlBytes = xml.getBytes(StandardCharsets.UTF_8);
//        final String xmlBase64 = Base64.getEncoder().encodeToString(xmlBytes);
//        System.out.println(xml);
//        System.out.println(xmlBase64);
//
//        final byte[] xmlBytesDecoded = Base64.getDecoder().decode(xmlBase64);
//        final String xmlDecoded = new String(xmlBytesDecoded, StandardCharsets.UTF_8);
//        System.out.println(xmlDecoded);

    }
}
