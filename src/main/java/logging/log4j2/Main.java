package logging.log4j2;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.properties.PropertiesConfiguration;
import org.apache.logging.log4j.core.config.xml.XmlConfiguration;

import java.io.FileInputStream;
import java.net.URI;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Configurator.initialize(LogManager.ROOT_LOGGER_NAME, "src/main/java/logging/log4j2/log4j2.properties");
        new Actor().run();
    }
}
