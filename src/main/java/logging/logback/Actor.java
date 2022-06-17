package logging.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Actor {
    private static final Logger LOGGER = LoggerFactory.getLogger(Actor.class);

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                LOGGER.info("Error " + i);
            } else {
                LOGGER.debug("Error " + i);
            }
        }
        LOGGER.error("ERROR!!!!", new RuntimeException());
    }
}
