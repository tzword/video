package com.tzword.demo.video;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 把视频按照每秒多少帧分割成图片
 */
public class FfmpegVideoToImgTest {
    private String ffmpegExePath;

    public FfmpegVideoToImgTest(String ffmpegExePath) {
        this.ffmpegExePath = ffmpegExePath;
    }

    public void convert(String inputViewPath,String outputViewPath) throws Exception {
        //ffmpeg.exe -i d:\video_in\heshui.mp4 -r 1 -f image2 d:\video_out\image-%3d.jpeg
        List<String> command = new ArrayList();
        command.add(ffmpegExePath);
        command.add("-i");
        command.add(inputViewPath);
        command.add("-r");
        command.add("1");//代表每秒一张图片
        command.add("-f");
        command.add("image2");//按照image2的格式导出
        command.add(outputViewPath);//图片地址
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
        FfmpegVideoToImgTest ffmpegTest = new FfmpegVideoToImgTest("D:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpegTest.convert("D:\\video_in\\caoyuan.mp4","D:\\video_out\\img2\\image-%3d.jpeg");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
