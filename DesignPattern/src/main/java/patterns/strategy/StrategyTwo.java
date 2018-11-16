package patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrategyTwo implements Strategy{

    private Logger logger;

    public StrategyTwo() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public void perform() {
        logger.info("perform onAction of strategy: [{}]", this.getClass().getName());
    }
}
