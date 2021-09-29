package _3._19.task7;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Util {
    public static String getLineFromFile(String path, int countLine) {
        StringBuilder builder = new StringBuilder();
        String strLine;
        try (LineNumberReader reader = new LineNumberReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8))) {
            while (((strLine = reader.readLine()) != null) && reader.getLineNumber() <= countLine) {
                builder.append(strLine).append(System.lineSeparator());
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Unable to read the file.");
        }
        return builder.toString();
    }
}
