package logging.jul;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Actor {
    private static final Logger LOGGER = Logger.getLogger(Actor.class.getName());

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                LOGGER.log(Level.INFO, "Error {0}", i);
            } else {
                LOGGER.log(Level.FINE, "ERROR {0}", i);
            }
        }
        LOGGER.log(Level.SEVERE, "ERROR!!!!", new RuntimeException());
    }
}
