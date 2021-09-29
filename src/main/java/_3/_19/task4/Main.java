package _3._19.task4;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Mapper<Box> boxMapper = Util.getBoxMapper();

        Box box1 = new Box();
        Map<String, String> map1 = new HashMap<>();
        map1.put("color", "white");
        map1.put("title", "test 1");
        map1.put("from", "Ukraine");
        System.out.println("Before box1: " + box1);
        boxMapper.populateValuesTo(map1, box1);
        System.out.println("After box1: " + box1);

        System.out.println();

        Box box2 = new Box();
        Map<String, String> map2 = new HashMap<>();
        map2.put("color", "black");
        map2.put("title", "test 2");
        map2.put("from", "Russia");
        System.out.println("Before box2: " + box2);
        boxMapper.populateValuesTo(map2, box2);
        System.out.println("After box2: " + box2);
    }
}
