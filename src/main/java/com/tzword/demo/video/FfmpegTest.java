package com.tzword.demo.video;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 转换视频格式（例如mp4->avi）
 */
public class FfmpegTest {
    private String ffmpegExePath;

    public FfmpegTest(String ffmpegExePath) {
        this.ffmpegExePath = ffmpegExePath;
    }

    public void convert(String inputViewPath,String outputViewPath) throws Exception {
        List<String> command = new ArrayList();
        command.add(ffmpegExePath);
        command.add("-i");
        command.add(inputViewPath);
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
        FfmpegTest ffmpegTest = new FfmpegTest("D:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpegTest.convert("D:\\input.mp4","D:\\output.avi");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
