package _3._18.task1;

public class Main {
    public static void main(String[] args) {
        String fileName1 = "src/main/java/ioNio/task1/test.txt";
        String fileName2 = "src/main/java/ioNio/task1/theLongestWord.txt";

        String theLongestWord = FileUtil.readFromFile(fileName1);
        System.out.printf("The longest word {%s} - %d%n", theLongestWord, theLongestWord.length());

        FileUtil.writeToFile(fileName2, theLongestWord);
    }
}
