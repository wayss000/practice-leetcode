package pers.wayss;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 随机复习一道题.
 * 程序输出哪道就复习哪一道.
 *
 * @author Wayss.
 * @date 2020/6/19.
 */
public class Review {
    public static void main(String[] args) {
        int targetCount = 110;
        List<String> testPathLst = new ArrayList<>();
        File file = new File("./src/main/java/pers/wayss");
        File[] listFiles = file.listFiles();
        int alreadyLearnCount = listFiles.length;
        System.out.println("已经刷题" + alreadyLearnCount + "道，距离百题斩仅剩：" + (targetCount - alreadyLearnCount));
        for (File f : listFiles) {
            if (f.isDirectory()) {
                testPathLst.add(f.getName());
            }
        }
        Random random = new Random();
        int index = random.nextInt(testPathLst.size());
        System.out.println(testPathLst.get(index));
    }
}
