package pers.wayss.aRun;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
                .filter(name -> !name.contains("aRun"))
                .collect(Collectors.toList());

        int alreadyLearnCount = testPathLst.size();
        System.out.println("已经刷题" + alreadyLearnCount + "道。");

        Random random = new Random();
        boolean printTen = true;
        if (printTen) {
            for (int i = 0; i < 10; i++) {
                printCodeName(random, testPathLst);
            }
        } else {
            printCodeName(random, testPathLst);
        }
    }

    private static void printCodeName(Random random, List<String> testPathLst) {
        int index = random.nextInt(testPathLst.size());
        System.out.println(testPathLst.get(index));
    }
}
