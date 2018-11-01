package patterns.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractSubject implements Subject {

    private Strategy strategy;
    protected Logger logger;

    public AbstractSubject() {
        this.logger = LoggerFactory.getLogger(this.getClass());
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void performStrategy() {
        this.strategy.perform();
    }

    public abstract void action();
}
