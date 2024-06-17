package pers.wayss;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 随机复习一道题.
 * 程序输出哪道就复习哪一道.
 *
 * @author Wayss.
 * @date 2020/6/19.
 */
public class Review {
    public static void main(String[] args) {
        File file = new File("./src/main/java/pers/wayss");
        File[] listFiles = file.listFiles();
        List<File> list = Arrays.asList(listFiles);
        List<String> testPathLst = list.stream()
                .filter(File::isDirectory)
                .map(File::getName)
                .filter(name -> !name.contains("common"))
                .collect(Collectors.toList());

        int alreadyLearnCount = testPathLst.size();
        System.out.println("已经刷题" + alreadyLearnCount + "道。");

        Random random = new Random();
        int index = random.nextInt(testPathLst.size());
        System.out.println(testPathLst.get(index));
    }
}
