package logging.jul;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.LogManager;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        final File file = new File("src/main/java/logging/jul/logging.properties");
        LogManager.getLogManager().readConfiguration(new FileInputStream(file));
        new Actor().run();
    }
}
