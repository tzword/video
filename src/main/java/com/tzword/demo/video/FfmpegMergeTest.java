package com.tzword.demo.video;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 把原视频的背景音乐替换为指定的音乐
 */
public class FfmpegMergeTest {
    private String ffmpegExePath;

    public FfmpegMergeTest(String ffmpegExePath) {
        this.ffmpegExePath = ffmpegExePath;
    }

    public void convert(String inputViewPath,String mp3ViewPath,String seconds,String outputViewPath) throws Exception {
        //ffmpeg.exe -i d:/video/input.mp4 -i d:/video/djsona.mp3 -t 20 -y d:/video/新的视频.mp4
        List<String> command = new ArrayList();
        command.add(ffmpegExePath);
        command.add("-i");
        command.add(inputViewPath);
        command.add("-i");
        command.add(mp3ViewPath);
        command.add("-t");
        command.add(seconds);
        command.add("-y");
        command.add(outputViewPath);
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process start = processBuilder.start();
        //关闭流
        InputStream errorStream = start.getErrorStream();
        InputStreamReader inputStreamReader = new InputStreamReader(errorStream);
        BufferedReader br = new BufferedReader(inputStreamReader);
        String line = "";
        while ((line = br.readLine()) == null){
        }
        if (br != null){
            br.close();
        }
        if (inputStreamReader != null){
            inputStreamReader.close();
        }
        if (errorStream != null){
            errorStream.close();
        }
    };

    public static void main(String[] args) {
        FfmpegMergeTest ffmpegTest = new FfmpegMergeTest("D:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpegTest.convert("D:\\video\\input.mp4","D:\\video\\djsona2.mp3","20","D:\\video\\java生成的视频.avi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
