package _3._19.task6;

public class Main {
    /**
     * Write a Java program to append text to an existing file and show all its content
     */
    public static void main(String[] args) {
        String path = "src/main/java/_3/_19/task6/text.txt";
        Util.appendText(path, "\nJava Exercises");
        Util.printContent(path);
    }
}
