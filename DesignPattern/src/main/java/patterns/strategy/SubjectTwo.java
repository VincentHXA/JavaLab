package patterns.strategy;

public class SubjectTwo extends AbstractSubject{

    public SubjectTwo() {
    }

    @Override
    public void action() {
        logger.info("onAction of [{}]", this.getClass().getName());
        performStrategy();
    }
}
