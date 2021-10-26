package com.company;

import java.io.*;
import java.util.Random;

public class Main {

    static int Max = 100;
    static int Min = 1;

    public static void main(String[] args) throws IOException {
        // write your code here


        String filepath = System.getProperty("user.dir");
        for (int i = 1; i <= 50; i++) {
            String subtxt = "data" + i + ".txt";
            filepath += "\\Demotxt" + "\\" + subtxt;

            System.out.println("当前目录" + filepath);

            try {
                File file = new File(filepath);
                if (!file.exists()) {
                    file.createNewFile();
                    System.out.println("data.txt创建完成");
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);

                //产生随机数，写入文件
                //创建随机种子
                Random rand = new Random();
                for (int j = 0; j < 1000; j++) {
                    String sub = "";
                    for (int k = 0; k < 3; k++) {
                        int randint = rand.nextInt(Max - Min - 1) + 1;
                        //一行三个随机数
                        sub = sub + randint + ",";
                    }
                    int length = sub.length();
                    bw.write(sub.substring(0, length - 1));
                    bw.newLine();
                }
                bw.close();
                fw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            filepath = System.getProperty("user.dir");
        }
        String dirpath = System.getProperty("user.dir");
        dirpath += "\\Demotxt";
        try {
            readfile(dirpath);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }


    public static void readfile(String filepath) throws FileNotFoundException, IOException {
        try {
            File file = new File(filepath);
            if (!file.isDirectory()) {
                System.out.println("文件");
            } else if (file.isDirectory()) {
                System.out.println("文件夹");
                String[] filelist = file.list();
                for (int i = 0; i < filelist.length; i++) {
                    File readfile = new File(filepath + "\\" + filelist[i]);
                    if (!readfile.isDirectory()) {
                        System.out.println("path=" + readfile.getPath());
                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
                        System.out.println("name=" + readfile.getName());

                    } else if (readfile.isDirectory()) {
                        readfile(filepath + "\\" + filelist[i]);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("readfile() Exception:" + e.getMessage());
        }
    }


}
