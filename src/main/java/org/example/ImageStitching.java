package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImageStitching {
    public static void main(String[] args) throws IOException {
        // 硬编码图片路径
        String path1 = "/home/luolu/IdeaProjects/jythonTest/Data/img1.png";
        String path2 = "/home/luolu/IdeaProjects/jythonTest/Data/img1_mask.png";

        // 指定Python环境路径
        String pythonPath = "/usr/bin/python3";

        // 激活Python虚拟环境
        String envPath = "/media/luolu/3cc826d6-a968-4df2-9ae7-ee2c324675bd/home/xkjs/PycharmProjects/lamaCleaner/venv/bin/activate";
        String[] envCmd = new String[]{"/bin/bash", "-c", "source " + envPath};
        Process envProcess = Runtime.getRuntime().exec(envCmd);

        // 调用Python脚本进行图片拼接
        String scriptPath = "/media/luolu/3cc826d6-a968-4df2-9ae7-ee2c324675bd/home/xkjs/PycharmProjects/lamaCleaner/lama_cleaner/model/javaTransferImg.py";
        String[] cmd = new String[]{pythonPath, scriptPath, path1, path2};
        Process process = Runtime.getRuntime().exec(cmd);

        // 获取Python脚本返回的结果
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String result = reader.readLine();
        System.out.println("Python脚本返回结果：" + result);

        // 保存拼接后的图片到本地
        String savePath = "stitched_image.jpg";
        File file = new File(savePath);
        if (file.exists()) {
            file.delete();
        }
        process = Runtime.getRuntime().exec("cp result.jpg " + savePath);
        System.out.println("图片保存成功：" + savePath);
    }
}

