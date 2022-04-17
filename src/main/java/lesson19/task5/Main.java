package lesson19.task5;

public class Main {
    /**
     * Write a java program to read a file line by line and store it into a variable.
     */
    public static void main(String[] args) {
        String fileContent = Util.getFileContent("src/main/java/lesson19/task5/text.txt");
        System.out.println(fileContent);
    }
}
