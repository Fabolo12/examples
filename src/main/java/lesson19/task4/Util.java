package lesson19.task4;

import java.util.Map;

public class Util {
    public static Mapper<Box> getBoxMapper() {
        return (values, object) -> {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                switch (key) {
                    case "color" -> object.setColor(value);
                    case "title" -> object.setTitle(value);
                    case "from" -> object.setFrom(value);
                    default -> throw new IllegalStateException(key);
                }
            }
        };
    }
}
