package com.company;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyHomeWork {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
//        // 文件输入流
//        FileInputStream fileInputStream = null;
//        // 读取文件
//
////        BufferedReader bufferedReader = null;
        try {
            // 创建核心线程数15，最大线程数15，存活时间一分钟的线程池
            ThreadPoolExecutor executor = new ThreadPoolExecutor(15, 15, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(50));
            AtomicInteger atomicInteger = new AtomicInteger(0);
            // 初始化CountDownLatch  用于等待多线程完成，以便后面读取文件
            CountDownLatch countDownLatch = new CountDownLatch(50);
            // 生成50个文件
            for (int i = 0; i < 50; i++) {
                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println(Thread.currentThread().getName());
                            File file = new File(atomicInteger.getAndIncrement() + ".txt");
                            // 判断文件是否存在  不存在则创建
                            if (!file.exists()) {
                                file.createNewFile();
                            }
                            StringBuilder sb = new StringBuilder();
                            // 生成1000行，每行3个 随机数
                            createRandomNum(1000, 3, sb);
                            long Threadid=Thread.currentThread().getId()%15+1;
                            System.out.println("thread"+"of"+Threadid);
                            // 文件输出流
                            PrintWriter printWriter = new PrintWriter(new FileOutputStream(file));
                            printWriter.write(sb.toString().toCharArray());
                            printWriter.flush();
                            printWriter.close();
                            // 每次执行完调用
                            countDownLatch.countDown();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            executor.shutdown();
            // 在此处等待所有的任务完成
            countDownLatch.await();
            // 存储每个文件的奇数/偶数的百分比
            List<Double> doubleList = new ArrayList<>();
            AtomicInteger atomicInteger1 = new AtomicInteger(0);
            ConcurrentHashMap<Integer,Double> concurrentHashMap=new ConcurrentHashMap<>();
            ThreadPoolExecutor executor1 = new ThreadPoolExecutor(15, 15, 1, TimeUnit.MINUTES, new LinkedBlockingDeque<>(50));

            CountDownLatch countDownLatch1 = new CountDownLatch(50);
            // 读取文件
            for (int i = 0; i < 50; i++) {
                executor1.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 文件中全部为奇数个数
                            int n = 0;
                            // 文件中全部为偶数个数
                            int m = 0;
                            int fileName = atomicInteger1.getAndIncrement();
                            File rFile = new File(fileName + ".txt");
                            // 判断文件是否存在
                            if (rFile.exists()) {
//                                fileInputStream = new FileInputStream(rFile);
                                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(rFile));
                                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                                String line = null;
                                while ((line = bufferedReader.readLine()) != null) {
                                    String[] numberStr = line.split(" ");
                                    for (String number : numberStr) {
                                        // 判断这个number是否全部为奇数或者偶数
                                        int result = checkOddOrEven(number);
                                        if (result == 1) {
                                            n++;
                                        }
                                        if (result == 2) {
                                            m++;
                                        }
                                    }
                                }
                                // 全奇数/全偶数  结果保留两位小数
                                double reslut = new BigDecimal((float) n / m).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                              //  int i=atomicInteger1.get();
                                concurrentHashMap.put(fileName,reslut);
                                countDownLatch1.countDown();
                                bufferedReader.close();
//                    doubleList.add(reslut);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

            }

            executor1.shutdown();
            // 在此处等待所有的任务完成
            countDownLatch1.await();

            for (int i=0;i<50;i++){
                doubleList.add(concurrentHashMap.get(i));
            }

            drawImage(doubleList);
            System.out.println("多线程耗时：" + (System.currentTimeMillis() - startTime));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //inputStreamReader.close();
            //fileInputStream.close();

            //bufferedReader.close();

        }
    }

    /**
     * 根据百分比结果画柱状图
     *
     * @param dataList
     */
    private static void drawImage(List<Double> dataList) throws IOException {
        // 图形宽
        int width = 2000;
        // 图形高
        int height = 800;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 绘制图像
        Graphics g = image.getGraphics();
        // 填充白色
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);
        // 画纵轴
        g.setColor(Color.black);
        g.drawLine(40, 10, 40, 760);
        // 画横轴
        g.drawLine(40, 760, 1950, 760);
        // 写纵轴
        g.setColor(Color.black);
        g.setFont(new Font("宋体", Font.PLAIN, 13));
        for (int i = 19; i >= 0; i--) {
            g.drawString(i * 10 + "%", 8, 760 - 38 * i);
        }
        // 写横轴
        for (int i = 1; i <= 50; i++) {
            g.drawString(java.lang.Integer.toString(i), i * 35 + 35, 780);
        }

        // 生成每个文件的柱形
        for (int file = 1; file <= 50; file++) {
            int rate = (int) (dataList.get(file - 1) * 400);
            g.setColor(Color.red);
            g.drawRect(file * 35 + 30, 760 - rate, 20, rate);
            g.fillRect(file * 35 + 30, 760 - rate, 20, rate);
        }
        g.dispose();
        // 生成图片
        File imageFile = new File("image.PNG");
        if (!imageFile.exists()) {
            imageFile.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(imageFile);
        ImageIO.write(image, "PNG", fileOutputStream);
        fileOutputStream.close();
    }


    /**
     * 判断给定的数字是否全部为奇数或者全部为偶数
     *
     * @param number 0 既有奇数也有偶数   1 全部为奇数  2 全部为偶数
     * @return
     */
    private static int checkOddOrEven(String number) {
        // 奇数个数
        int oddCount = 0;
        // 偶数个数
        int evenCount = 0;
        for (int i = 0; i < number.length(); i++) {
            Integer integer = Integer.valueOf(number.substring(i, i + 1));
            // 偶数
            if (integer % 2 == 1) {
                oddCount++;
            } else {
                evenCount++;
            }
        }
        if (oddCount == number.length()) {
            // 全部为奇数
            return 1;
        } else if (evenCount == number.length()) {
            // 全部为偶数
            return 2;
        } else {
            // 既有奇数也有偶数
            return 0;
        }
    }


    /**
     * 生成随机数
     *
     * @param line   多少行
     * @param column 多少列
     * @param sb     拼接生成的数据
     */
    private static void createRandomNum(int line, int column, StringBuilder sb) {
        Random random = new Random();
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                sb.append(random.nextInt(1000));
                sb.append(" ");
            }
            // 换行
            sb.append(System.lineSeparator());
        }
    }


}
