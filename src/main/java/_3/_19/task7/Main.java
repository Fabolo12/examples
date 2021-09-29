package _3._19.task7;

public class Main {
    /**
     * Write a Java program to read first 3 lines from a file.
     */
    public static void main(String[] args) {
        String fromFile = Util.getLineFromFile("src/main/java/_3/_19/task7/text.txt", 3);
        System.out.println(fromFile);
    }
}
