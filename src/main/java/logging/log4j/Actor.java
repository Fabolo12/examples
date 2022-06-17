package logging.log4j;

import org.apache.log4j.Logger;

public class Actor {
    private final static Logger LOGGER = Logger.getLogger(Actor.class);

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
