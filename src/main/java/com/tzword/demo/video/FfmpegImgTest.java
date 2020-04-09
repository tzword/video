package com.tzword.demo.video;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 转换视频格式（例如mp4->avi）
 */
public class FfmpegImgTest {
    private String ffmpegExePath;

    public FfmpegImgTest(String ffmpegExePath) {
        this.ffmpegExePath = ffmpegExePath;
    }

    public void convert(String inputViewPath,String outputViewPath) throws Exception {
        //ffmpeg.exe -ss 00:00:10 -y -i d:/video/input.mp4 -vframes 1 d:/video/new2.jpg
        List<String> command = new ArrayList();
        command.add(ffmpegExePath);
        command.add("-ss");
        command.add("00:00:15");
        command.add("-y");
        command.add("-i");
        command.add(inputViewPath);
        command.add("-vframes");
        command.add("1");
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
        FfmpegImgTest ffmpegTest = new FfmpegImgTest("D:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpegTest.convert("D:\\video\\input.mp4","D:\\video\\java生成的截图.jpg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
