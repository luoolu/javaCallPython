package org.example;

import java.io.IOException;

public class RunPythonScript {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "bash",
                    "-c",
                    "source /media/luolu/3cc826d6-a968-4df2-9ae7-ee2c324675bd/home/xkjs/PycharmProjects/lamaCleaner/venv/bin/activate && " +
                            "/media/luolu/3cc826d6-a968-4df2-9ae7-ee2c324675bd/home/xkjs/PycharmProjects/lamaCleaner/venv/bin/python " +
                            "/media/luolu/3cc826d6-a968-4df2-9ae7-ee2c324675bd/home/xkjs/PycharmProjects/lamaCleaner/lama_cleaner/model/batch_inference_fcf.py"
            );
            pb.inheritIO(); // Redirects the subprocess's standard output and error to the Java process's standard output and error streams
            Process p = pb.start();
            int exitCode = p.waitFor();
            System.out.println("Python script finished with exit code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

