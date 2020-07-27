package com.xtel.training.bai_6a;

import com.xtel.training.common.utils.FileUtil;

import java.util.Random;

public class SetNumberThread extends Thread {

    private static final String SRC_PATH = System.getProperty("user.dir");
    private static String FILE_PATH = SRC_PATH + "\\config\\output.txt";

    final Random random = new Random();

    private int number;

    private boolean isRunning = false;

    @Override
    public void run() {
        isRunning = true;
        while (isRunning) {
            number = random.nextInt(100);
            try {
                FileUtil.writeFile(FILE_PATH, number + " ", true);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setStop() {
        isRunning = false;
    }
}
