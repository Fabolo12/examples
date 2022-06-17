package logging.log4j;

import lombok.SneakyThrows;
import org.apache.log4j.PropertyConfigurator;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/main/java/logging/log4j/log4j.properties");
        new Actor().run();
    }
}
