package com.github.aelmod.geekhub.homework6.task2;

/**
 * Created by Євгеній on 28.11.2016.
 */
public class App {
    public static int iterationsCount = 15000;

    public static long stringTest() {
        long startTime = System.currentTimeMillis();
        String string = "RainbowDash";
        for (int i = 0; i < iterationsCount; i++) {
            string = string + "PinkiePie";
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long stringBuilderTest() {
        long startTime = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RainbowDash");
        for (int i = 0; i < iterationsCount; i++) {
            stringBuilder.append("PinkiePie");
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static long stringBufferTest() {
        long startTime = System.currentTimeMillis();
        StringBuffer stringBuffer = new StringBuffer("RainbowDash");
        for (int i = 0; i < iterationsCount; i++) {
            stringBuffer.append("PinkiePie");
        }
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        System.out.println("Concat performance test for String: " + stringTest() + "ms");
        System.out.println("Concat performance test for StringBuffer: " + stringBufferTest() + "ms");
        System.out.println("Concat performance test for StringBuilder: " + stringBuilderTest() + "ms");
    }
}
