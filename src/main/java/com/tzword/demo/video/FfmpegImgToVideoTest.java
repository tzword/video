package com.tzword.demo.video;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 把图片再合成为视频
 */
public class FfmpegImgToVideoTest {
    private String ffmpegExePath;

    public FfmpegImgToVideoTest(String ffmpegExePath) {
        this.ffmpegExePath = ffmpegExePath;
    }

    public void convert(String inputViewPath,String outputViewPath) throws Exception {
        //ffmpeg.exe -i d:\video_out\img\image-%3d.jpeg d:\video_out\outimg.mp4
        List<String> command = new ArrayList();
        command.add(ffmpegExePath);
        command.add("-i");
        command.add(inputViewPath);//图片地址
        command.add(outputViewPath);//视频地址
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
        FfmpegImgToVideoTest ffmpegTest = new FfmpegImgToVideoTest("D:\\ffmpeg\\bin\\ffmpeg.exe");
        try {
            ffmpegTest.convert("D:\\video_out\\img2\\image-%3d.jpeg","D:\\video_out\\hecheng.mp4");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
