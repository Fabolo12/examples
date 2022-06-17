package logging.commons;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Actor {
    private final static Log LOGGER = LogFactory.getLog(Actor.class);

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
