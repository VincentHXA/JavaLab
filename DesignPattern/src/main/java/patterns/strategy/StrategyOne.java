package patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StrategyOne implements Strategy{

    private Logger logger;

    public StrategyOne() {
        logger = LoggerFactory.getLogger(this.getClass());
    }

    public void perform() {
        logger.info("perform onAction of strategy: [{}]", this.getClass().getName());
    }
}
