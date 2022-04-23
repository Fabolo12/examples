package lesson19.task2;

import java.util.Set;

public class Main {
    /**
     * Написать метод который создает Set с помощью Comparator, который помещает сначала
     * нулевой элемент и сортирует по длине слова
     */
    public static void main(String[] args) {
        Set<String> sortedSet = Util.getSortedSet("XML", "CSS", "HTML", null);
        sortedSet.forEach(System.out::println);
    }
}
