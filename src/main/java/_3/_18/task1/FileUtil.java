package _3._18.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    static String readFromFile(String fileName) {
        int wordCount = 0;
        String theLongestWord = "";
        StringBuilder builder = new StringBuilder();
        try (FileInputStream inFile = new FileInputStream(fileName)) {
            int i;
            while ((i = inFile.read()) != -1) {
                char cr = (char) i;
                if (cr == ' ' || cr == '\n') {
                    String word = builder.toString();
                    if (theLongestWord.length() < word.length()) {
                        theLongestWord = word;
                    }
                    System.out.println(builder);
                    wordCount++;
                    builder = new StringBuilder();
                } else {
                    builder.append(cr);
                }
            }
            wordCount++;
            System.out.println("Total words: " + wordCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return theLongestWord;
    }

    static void writeToFile(String fileName, String theLongestWord) {
        try (FileOutputStream outFile = new FileOutputStream(fileName)) {
            outFile.write(theLongestWord.getBytes());
            outFile.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
