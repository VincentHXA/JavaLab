package patterns.strategy;

public class SubjectOne extends AbstractSubject{

    public SubjectOne() {
    }

    @Override
    public void action() {
        logger.info("action of [{}]", this.getClass().getName());
        performStrategy();
    }
}
