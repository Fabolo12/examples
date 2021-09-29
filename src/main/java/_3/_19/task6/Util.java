package _3._19.task6;

import java.io.*;

public class Util {
    public static void appendText(String path, String text) {
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(text);
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }

    public static void printContent(String path) {
        StringBuilder sb = new StringBuilder();
        String strLine;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            strLine = br.readLine();
            while (strLine != null) {
                sb.append(strLine);
                sb.append(System.lineSeparator());
                strLine = br.readLine();
            }
        } catch (IOException ioe) {
            System.err.println("IOException: " + ioe.getMessage());
        }
        System.out.println(sb);
    }
}
