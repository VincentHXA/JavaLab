import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    private Logger logger;

    @Before
    public void setUp() throws Exception {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    @Test
    public void testLog() {
        logger.info("info");
        logger.info("info [{}]", "hello world");
        logger.error("error");
    }
}
