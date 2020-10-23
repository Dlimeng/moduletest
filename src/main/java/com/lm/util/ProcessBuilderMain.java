package com.lm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * @Classname ProcessBuilderMain
 * @Description TODO
 * @Date 2020/10/22 20:21
 * @Created by limeng
 * window "CMD","/C"
 * linux sh -c   /bin/bash -c
 */
public class ProcessBuilderMain {
    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedReader errorsReader = null;
        Process process = null;
        ProcessBuilder processBuilder = new ProcessBuilder("CMD","/C","java -version");

        processBuilder.redirectErrorStream(true);
        processBuilder.redirectInput(ProcessBuilder.Redirect.PIPE);
        try {

            process = processBuilder.start();

            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            errorsReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            int exitVal = process.waitFor();
            System.out.println("Exited with error code " + exitVal);


            String erroLine = null;
            while ((erroLine = errorsReader.readLine()) != null){
                System.out.println("error "+erroLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
